package lsg;

import java.util.Scanner;

import lsg.characters.*;
import lsg.consumables.*;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.*;
import lsg.exceptions.StaminaEmptyException;
import lsg.exceptions.WeaponBrokenException;
import lsg.exceptions.WeaponNullException;
import lsg.armor.*;
import lsg.bags.Bag;
import lsg.bags.MediumBag;
import lsg.bags.SmallBag;
import lsg.buffs.rings.RingOfDeath;
import lsg.weapons.*;

public class LearningSoulsGame {
	
	public static final String BULLET_POINT = "  \u2022 ";
	
	Hero hero = new Hero("Le chevalier Couscous", 250, 100);
	Monster monster = new Monster("Gilles de Rais", 300, 70);
	Scanner scan = new Scanner(System.in);
	private Hero ea;

	/**
	 * Main lance le programme
	 * @param args
	 * @throws WeaponNullException
	 */
	public static void main(String[] args) throws WeaponNullException {
		
		LearningSoulsGame lsg = new LearningSoulsGame();
		lsg.init();
		
		lsg.testExceptions();
		
	}
	
	/**
	 * refresh affiche les stats
	 */
	public void refresh() {
		this.hero.printStats();
		System.out.println(this.hero.armorToString());
		this.hero.printRings();
		this.hero.printConsumable();
		this.hero.printWeapon();
		this.hero.printBag();
		
		System.out.println("\n");
		this.monster.printStats();
		this.monster.printWeapon();
	}
	
	/**
	 * script de combat entre le heros et le monstre
	 * @return
	 */
	public int fight1v1() {
		while (this.hero.isAlive() && this.monster.isAlive()) {
			
			refresh();
			System.out.println("Action : attack (1) | consume (2)");
			int action = scan.nextInt();
			boolean foo = true;
			
			while (foo) {
				switch (action) {
				case 1:
					try {
						this.hero.battle(this.monster);
					} catch (WeaponNullException e) {
						// TODO Auto-generated catch block
						this.hero.setWeapon(new Weapon("no weapon", 0, 0, 0, 2));
						System.out.println("No weapon has been equipped");
					} catch (WeaponBrokenException e) {
						System.out.println(this.hero.getWeapon() + " is broken");
					} catch (StaminaEmptyException e) {
						// TODO Auto-generated catch block
						System.out.println("ATTACK HAS NO EFFECT : " + e.getStackTrace());
					}
					foo = false;
					break;
					
				case 2:
					this.hero.consume();
					foo = false;
					break;

				default:
					System.out.println("Action : attack (1) | consume (2)");
					action = scan.nextInt();
					break;
				}
			}
			
			if (!this.monster.isAlive()) {
				System.out.println(this.hero.getName() + " est victorieux !");
				return 0;
			}
			
			//refresh();
			try {
				this.monster.battle(this.hero);
			} catch (WeaponNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (StaminaEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WeaponBrokenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//action = scan.nextInt();
			if (!this.hero.isAlive()) {
				System.out.println(this.monster.getName() + " vous a mangé ...");
				return 0;
			}
		}
		return 0;
	}
	
	/**
	 * equipe nos personnages
	 */
	public void init() {
		this.hero.setWeapon(new Sword("La couscoussière", 60, 100, 15, 100));
		this.hero.setConsumable(new Hamburger());
		this.monster.setWeapon(new Claw("La jugulaire", 25, 125, 9, 175));
	}
	
	/**
	 * regroupe init et fight
	 */
	public void play_v1(){
		init();
		fight1v1();
	}
	
	/**
	 * playv1 en equipant de l'armure au héros
	 */
	public void play_v2(){
		this.hero.setArmorItem(new RingedKnightArmor(), 1);
		this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
		init();
		fight1v1();
	}
	
	/**
	 * equipe des anneaux et lance le combat
	 */
	public void play_v3() {
		this.hero.setArmorItem(new RingedKnightArmor(), 1);
		this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
		this.hero.setRing(new RingOfDeath(), 1);
		this.monster = new Lycanthrope();
		init();
		fight1v1();

	}
	
	/**
	 * créé un héros avec 1 pv et sans stam
	 * @throws WeaponNullException
	 * @throws WeaponBrokenException
	 * @throws StaminaEmptyException
	 */
	public void createExhaustedHero() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException {
        this.ea.getHitWith(99);
        this.ea.setWeapon(new Weapon("Enuùma-KUN", 0, 0, 1000, 100));
        this.ea.attack();
        this.ea.printStats();
    }
	
	/**
	 * test exception no weapon
	 * @throws WeaponNullException
	 */
	public void testExceptions() throws WeaponNullException {
		this.hero.setWeapon(null);
		this.fight1v1();
	}
}
