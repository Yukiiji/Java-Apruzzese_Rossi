package lsg.buffs.rings;

import lsg.buffs.BuffItem;
import lsg.characters.Hero;

public abstract class Ring extends BuffItem {
	
	protected int power ; 
	protected Hero hero ;
	
	/**
	 * Constructeur
	 * @param name
	 * @param power
	 */
	public Ring(String name, int power) {
		super(name) ;
		this.power = power ;
	}
	
	/**
	 * Assigne un hero � un anneau
	 * @param hero
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	/**
	 * Retourne le h�ros assign� � l'anneau
	 * @return
	 */
	public Hero getHero() {
		return hero;
	}
	
}
