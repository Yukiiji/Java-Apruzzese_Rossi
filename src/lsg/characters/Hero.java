package lsg.characters;

import java.util.Arrays;

import lsg.LearningSoulsGame;
import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;
import lsg.buffs.rings.Ring;
import lsg.buffs.rings.RingOfSwords;

public class Hero extends Character{
	
	//tableau d'armures du héros
	private ArmorItem[] armor;
	
	private Ring[] ring;
	//Constante disant que le héros ne peut porter que 3 pièces d'armures
	private final int MAX_ARMOR_PIECES = 3;
	private final int MAX_RING_PIECES = 2;
	

	public Hero(String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;
		
		//On instancie le tableau avec une taille de 3
		this.armor = new ArmorItem[this.MAX_ARMOR_PIECES];
		
		this.ring = new Ring[this.MAX_RING_PIECES];
		
		//Pour chaque index du tableau on insert un objet armure, pour éviter des erreurs de null lors de l'addition d'armure
		for (int i = 0; i < armor.length; i++) {
			this.armor[i] = new ArmorItem();
		}
	}
	
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
	
	
	public static void main(String[] args) {
		
		Hero lancer = new Hero("Haka no RANSSA", 100, 100);
		DragonSlayerLeggings dsl = new DragonSlayerLeggings();
		
		lancer.setArmorItem(dsl, 2);
		System.out.println(lancer.armorToString());
	}
	
	
	//Méthodes
	
	//Methode pour attribuer une piece d'armure au héros, si le slot à attribuer est inférieur à 0 ou inférieur à 3 on ne fait rien
	// on effectue slot - 1 car un tableau commence à 0
	public float setArmorItem(ArmorItem armorPiece, int slot) {
		if (slot < 0 || slot > this.MAX_ARMOR_PIECES) {
			return 0;
		} 
		this.armor[slot - 1] = armorPiece;
		return armor[slot - 1].getArmorValue();
	}
	
	//Retourne la valeur totale d'armure
	public float getTotalArmor() {
		return this.armor[0].getArmorValue() + this.armor[1].getArmorValue() + this.armor[2].getArmorValue();
	}
	
	public String armorToString() {
		String slot1;
		String slot2;
		String slot3;
		
		slot1 = this.armor[0].getArmorValue() != 0 ? this.armor[0].toString() : "empty";
		slot2 = this.armor[1].getArmorValue() != 0 ? this.armor[1].toString() : "empty";
		slot3 = this.armor[2].getArmorValue() != 0 ? this.armor[2].toString() : "empty";
		
		return String.format("%-20s", "ARMOR") + String.format("%-40s", "1 : " + slot1) + String.format("%-40s", "2 : " + slot2) + String.format("%-40s", "3 : " + slot3) + String.format("%-40s", "TOTAL ARMOR : " + this.getTotalArmor());
	}
	
	public ArmorItem[] getArmorItem() {
		ArmorItem[] allArmors = new ArmorItem[0];
		for (int i = 0; i < this.armor.length; i++) {
			 if (this.armor[i].getArmorValue() != 0) {
				allArmors[i] = this.armor[i];
			}
		}
		return allArmors;
	}

	@Override
	public float computeProtection() {
		return this.getTotalArmor();
	}

	public float setRing(Ring r, int slot) {
		if (slot < 0 || slot > this.MAX_RING_PIECES) {
			return 0;
		} 
		this.ring[slot - 1] = r;
		r.setHero(this);
		return 1;
	}
	
	public Ring getRing(int slot) {
		if (slot < 0 || slot > this.MAX_RING_PIECES) {
			return null;
		}
		return this.ring[slot-1];
	}

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
	
	
}
