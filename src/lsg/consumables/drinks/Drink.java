package lsg.consumables.drinks;

import lsg.consumables.Consumables;
import lsg.characters.Character;


public abstract class Drink extends Consumables {
	
	/**
	 * Constructeur
	 * @param name
	 * @param capacity
	 */
    public Drink(String name, int capacity){
        super(name, capacity, Character.STAM_STAT_STRING);

    }
}
