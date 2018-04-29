package lsg;

import java.util.Scanner;

import lsg.characters.*;
import lsg.consumables.*;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.*;
import lsg.exceptions.WeaponNullException;
import lsg.armor.*;
import lsg.bags.Bag;
import lsg.bags.MediumBag;
import lsg.bags.SmallBag;
import lsg.buffs.rings.RingOfDeath;
import lsg.weapons.*;

public class LearningSoulsGame {
	
	public static final String BULLET_POINT = "  \u2022 ";
	
	//On instancie notre héros et notre monstre
	Hero hero = new Hero("Le chevalier Couscous", 250, 100);
	Monster monster = new Monster("Gilles de Rais", 300, 70);
	//On instancie un nouveau scanner pour enregistrer les entrées utilisateur
	Scanner scan = new Scanner(System.in);
	private Hero ea;

//Main : ce qui se lance lors de la compilation
	public static void main(String[] args) throws WeaponNullException {
		
		LearningSoulsGame lsg = new LearningSoulsGame();
		lsg.init();
		
		lsg.testExceptions();
		
	}
	
		//Fonction qui affiche les stats du héros et du monstre
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
	
	//tant que les héros et monstre sont en vie, on affiche leurs stats avec refresh -> le heros attaque -> on attends la saisie utilisateur
	// -> On check si  lemonstre est toujours en vie après l'attaque -> On fait pareil mais avec le monstre qui attaque
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
			}
			//action = scan.nextInt();
			if (!this.hero.isAlive()) {
				System.out.println(this.monster.getName() + " vous a mangé ...");
				return 0;
			}
		}
		return 0;
	}
	
	// Cette méthode va set les armes de nos personnages
	public void init() {
		this.hero.setWeapon(new Sword("La couscoussière", 60, 100, 15, 100));
		this.hero.setConsumable(new Hamburger());
		this.monster.setWeapon(new Claw("La jugulaire", 25, 125, 9, 175));
	}
	
	//Cette méthode est appelée dans le main. D'abord on appelle init() pour set les armes, ensuite on appelle fight1v1() pour les faire se totocher
	public void play_v1(){
		init();
		fight1v1();
	}
	
	public void play_v2(){
		this.hero.setArmorItem(new RingedKnightArmor(), 1);
		this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
		init();
		fight1v1();
	}
	
	public void play_v3() {
		this.hero.setArmorItem(new RingedKnightArmor(), 1);
		this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
		this.hero.setRing(new RingOfDeath(), 1);
		this.monster = new Lycanthrope();
		init();
		fight1v1();

	}
	
	public void createExhaustedHero() throws WeaponNullException {
        this.ea.getHitWith(99);
        this.ea.setWeapon(new Weapon("Enuùma-KUN", 0, 0, 1000, 100));
        this.ea.attack();
        this.ea.printStats();
    }
	
	public void testExceptions() throws WeaponNullException {
		this.hero.setWeapon(null);
		this.fight1v1();
	}
}
