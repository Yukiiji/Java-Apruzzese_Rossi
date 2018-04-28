package lsg.weapons;

import lsg.consumables.repair.RepairKit;

public class Weapon {
	
	protected String name;
	protected int minDamage, maxDamage, stamCost, durability;
	
	public static final String DURABILITY_STAT_STRING = "DURABILITY : ";
	
	public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.stamCost = stamCost;
		this.durability = durability;
	}

	public Weapon() {
		this.name = "Basic weapon";
		this.minDamage = 5;
		this.maxDamage = 10;
		this.stamCost = 20;
		this.durability = 100;
	}



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
	
	public void use() {
		this.durability--;
	}
	
	public Boolean isBroken() {
		if (this.durability <= 0) {
			return true;
		} else
			return false;
	}
	
	public String toString() {
		return this.name+" (Min: "+this.minDamage+" Max: "+this.maxDamage+" Stamina: "+this.stamCost+" Durability: "+this.durability+")";
	}
	
	public void whatIsMyWeapon() {
		System.out.println(this.toString());
	}
	
	public void repairWith(RepairKit kit) {
		kit.use();
	}
}
