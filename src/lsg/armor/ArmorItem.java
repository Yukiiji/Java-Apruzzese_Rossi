package lsg.armor;

import lsg.bags.Collectible;

public class ArmorItem implements Collectible{
	
	protected String name;
	protected float armorValue = 0;
	protected int weight = 4;
	
	
	/**
	 * Constructeur
	 * @param name
	 * @param armorValue
	 */
	public ArmorItem(String name, float armorValue) {
		this.name = name;
		this.armorValue = armorValue;
	}
	
	public ArmorItem() {

	}
	

	/**
	 * Getter
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter
	 * @return armorValue
	 */
	public float getArmorValue() {
		return armorValue;
	}
	
	
	/**
	 * Surchage de la methode toString
	 */
	@Override
	public String toString() {
		return this.name+" (" + this.armorValue + ")";
	}

	/**
	 * methode abstraite
	 */
	@Override
	public int getWeight() {
		return this.weight;
	}
}
