package lsg.consumables.food;

import lsg.consumables.Consumables;
import lsg.characters.Character;

public abstract class Food extends Consumables {
	
    public Food(String name, int capacity){
        super(name, capacity, Character.LIFE_STAT_STRING);

    }
}