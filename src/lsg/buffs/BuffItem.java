package lsg.buffs;

import java.util.Locale;

import lsg.bags.Collectible;

public abstract class BuffItem implements Collectible{
	
	private String name ; 
	protected int weight = 1;
	
	/**
	 * Constructeur
	 * @param name
	 */
	public BuffItem(String name) {
		this.name = name ;
	}
	
	/**
	 * methode abstraite definie dans les classes filles, permet de calculer la valeur des buffs
	 * @return
	 */
	public abstract float computeBuffValue() ;
	
	/**
	 * Getter
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Surchage de toString
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "[%s, %.2f]", getName(), computeBuffValue()) ;
	}
	
	/**
	 * Retourne le poids de l'objet
	 */
	@Override
	public int getWeight() {
		return this.weight;
	}
}
