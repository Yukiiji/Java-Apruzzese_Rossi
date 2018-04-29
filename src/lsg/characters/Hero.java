package lsg.characters;

import java.util.Arrays;

import lsg.LearningSoulsGame;
import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;
import lsg.bags.Collectible;
import lsg.buffs.rings.Ring;
import lsg.buffs.rings.RingOfSwords;
import lsg.weapons.Weapon;

public class Hero extends Character{
	
	private ArmorItem[] armor;
	
	private Ring[] ring;
	private final int MAX_ARMOR_PIECES = 3;
	private final int MAX_RING_PIECES = 2;
	
	/**
	 * Constructeur spécifiant le nom, la vie et la stamina du héros
	 * @param name
	 * @param maxLife
	 * @param maxStamina
	 */
	public Hero(String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;

		this.armor = new ArmorItem[this.MAX_ARMOR_PIECES];
		this.ring = new Ring[this.MAX_RING_PIECES];
		
		for (int i = 0; i < armor.length; i++) {
			this.armor[i] = new ArmorItem();
		}
	}
	
	/**
	 * Constructeur créant un héros par défaut
	 */
	public Hero() {
		super();
		this.name = "Ynovator";
		this.life = 100;
		this.maxLife = 100;
		this.stamina = 50;
		this.maxStamina = 50;
		this.armor = new ArmorItem[this.MAX_ARMOR_PIECES];
		this.ring = new Ring[this.MAX_RING_PIECES];
		for (int i = 0; i < armor.length; i++) {
			this.armor[i] = new ArmorItem();
		}
	}
	
	/**
	 * Main lance le programme
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hero lancer = new Hero("Haka no RANSSA", 100, 100);
		DragonSlayerLeggings dsl = new DragonSlayerLeggings();
		
		lancer.setArmorItem(dsl, 2);
		System.out.println(lancer.armorToString());
	}
	
	
	//Méthodes
	
	/**
	 * Zquipe un piece d'armure à l'emplavcement spécifié
	 * @param armorPiece
	 * @param slot
	 * @return
	 */
	public float setArmorItem(ArmorItem armorPiece, int slot) {
		if (slot < 0 || slot > this.MAX_ARMOR_PIECES) {
			return 0;
		} 
		this.armor[slot - 1] = armorPiece;
		return armor[slot - 1].getArmorValue();
	}
	
	/**
	 * Retourne la valeur totale d'armure
	 * @return
	 */
	public float getTotalArmor() {
		return this.armor[0].getArmorValue() + this.armor[1].getArmorValue() + this.armor[2].getArmorValue();
	}
	
	/**
	 * Affiche un récapitulatif de l'armure actuelle
	 * @return
	 */
	public String armorToString() {
		String slot1;
		String slot2;
		String slot3;
		
		slot1 = this.armor[0].getArmorValue() != 0 ? this.armor[0].toString() : "empty";
		slot2 = this.armor[1].getArmorValue() != 0 ? this.armor[1].toString() : "empty";
		slot3 = this.armor[2].getArmorValue() != 0 ? this.armor[2].toString() : "empty";
		
		return String.format("%-20s", "ARMOR") + String.format("%-40s", "1 : " + slot1) + String.format("%-40s", "2 : " + slot2) + String.format("%-40s", "3 : " + slot3) + String.format("%-40s", "TOTAL ARMOR : " + this.getTotalArmor());
	}
	
	/**
	 * Retourne les pieces d'armures équippées
	 * @return
	 */
	public ArmorItem[] getArmorItem() {
		ArmorItem[] allArmors = new ArmorItem[0];
		for (int i = 0; i < this.armor.length; i++) {
			 if (this.armor[i].getArmorValue() != 0) {
				allArmors[i] = this.armor[i];
			}
		}
		return allArmors;
	}

	/**
	 * Methode héritée qui calcule la'armure du héros
	 */
	@Override
	public float computeProtection() {
		return this.getTotalArmor();
	}

	/**
	 * Equipe un anneau au héros
	 * @param r
	 * @param slot
	 * @return
	 */
	public float setRing(Ring r, int slot) {
		if (slot < 0 || slot > this.MAX_RING_PIECES) {
			return 0;
		} 
		this.ring[slot - 1] = r;
		r.setHero(this);
		return 1;
	}
	
	/**
	 * Retourne l'anneau du slot passé en paramètre
	 * @param slot
	 * @return
	 */
	public Ring getRing(int slot) {
		if (slot < 0 || slot > this.MAX_RING_PIECES) {
			return null;
		}
		return this.ring[slot-1];
	}
	
	/**
	 * Methode héritée calculant le total des buffs
	 */
	@Override
	public float computeBuff() {

		float totalBuff = 0;
		for (Ring r : this.ring) {
			if (r != null) {
				totalBuff += r.computeBuffValue();
			}
		}
		return totalBuff;
	}
	
	/**
	 * Sort du sac une piece d'armure et l'équipe
	 * @param armor
	 * @param slot
	 */
	public void equip(ArmorItem armor, int slot) {
		
		Collectible[] items = this.getBagItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i] == armor) {
				if (this.setArmorItem(armor, slot) != 0) {
					this.pullOut(items[i]);
					System.out.println(this.getName() + " pulls out " + armor.toString() + " and equips it !");
				}
			}
		}
	}
	
	/**
	 * Sort du sac un anneau et l'équipe
	 * @param r
	 * @param slot
	 */
	public void equip(Ring r, int slot) {
		
		Collectible[] items = this.getBagItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i] == r) {
				if (this.setRing(r, slot) != 0) {
					this.pullOut(items[i]);
					System.out.println(this.getName() + " pulls out " + r.toString() + " and equips it !");
				}
			}
		}
	}
	
	/**
	 * Retourne une chaine formatée concernant les anneaux
	 * @return
	 */
	public String ringToString() {
		String slot1;
		String slot2;
		
		slot1 = this.ring[0] != null ? this.ring[0].toString() : "empty";
		slot2 = this.ring[1] != null  ? this.ring[1].toString() : "empty";

		
		return String.format("%-20s", "RINGS") + String.format("%-40s", "1 : " + slot1) + String.format("%-40s", "2 : " + slot2);
	}
	
	/**
	 * Affiche la chaine formatée de ringToString
	 */
	public void printRings() {
		System.out.println(this.ringToString());
	}
}
