package lsg.consumables;

import lsg.bags.Collectible;

public class Consumables implements Collectible{
	
	private String name, stat;
	private int capacity;
	protected int weight = 1;
	
	/**
	 * Constructeur
	 * @param name
	 * @param capacity
	 * @param stat
	 */
	
	public Consumables(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}
	
	
	/**
	 * Getters
	 * @return
	 */

	public String getName() {
		return name;
	}

	public String getStat() {
		return stat;
	}

	public int getCapacity() {
		return capacity;
	}
	
	
	/**
	 * Setter
	 * @param capacity
	 */
	
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	// Methodes

	/**
	 * Surchage de toString
	 */
	@Override
	public String toString() {
		return this.name + " [" + this.stat + " " + this.capacity + " point(s)]";
	}
	
	/**
	 * Vide un consommable
	 * @return
	 */
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(0);
		return capacity;
	}


	/**
	 * Methode h�rit�e qui retournee poids du consommable
	 */
	@Override
	public int getWeight() {
		return this.weight;
	}
}
