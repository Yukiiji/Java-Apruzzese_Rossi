package lsg.weapons;

import lsg.bags.Collectible;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.WeaponNullException;

public class Weapon implements Collectible{
	
	protected String name;
	protected int minDamage, maxDamage, stamCost, durability;
	protected int weight = 2;
	
	public static final String DURABILITY_STAT_STRING = "DURABILITY : ";
	
	/**
	 * Constructeur personnalisé
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;
	}

	/**
	 * Constructeur par défaut
	 */
	public Weapon() {
		this.name = "Basic weapon";
		this.minDamage = 5;
		this.maxDamage = 10;
		this.stamCost = 20;
		this.durability = 100;
	}

	/**
	 * Getters and setters
	 * @return
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getStamCost() {
		return stamCost;
	}

	public void setStamCost(int stamCost) {
		this.stamCost = stamCost;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	
	//Methods
	
	/**
	 * Décrémente la durabilité d'un objet
	 */
	public void use() {
		this.durability--;
	}
	
	/**
	 * Check si une arme est brisée
	 * @return
	 */
	public Boolean isBroken() {
		if (this.durability <= 0) {
			return true;
		} else
			return false;
	}
	
	
	/**
	 * Surchage de toString
	 */
	@Override
	public String toString() {
		return this.name+" (Min: "+this.minDamage+" Max: "+this.maxDamage+" Stamina: "+this.stamCost+" Durability: "+this.durability+")";
	}
	
	/**
	 * Affiche l'arme 
	 */
	public void whatIsMyWeapon() {
		System.out.println(this.toString());
	}
	
	/**
	 * Répare l'arme avec le kit passé en paramètre
	 * @param kit
	 */
	public void repairWith(RepairKit kit) {
		kit.use();
	}

	/**
	 * Methode héritée qui renvoie le poids de l'arme
	 */
	@Override
	public int getWeight() {
		return this.weight;
	}
}
