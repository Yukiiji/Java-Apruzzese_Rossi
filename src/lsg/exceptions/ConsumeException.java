
package lsg.exceptions;

import lsg.consumables.Consumables;


public abstract class ConsumeException extends Exception {

    private Consumables consumable;

    /**
     * Gere les issues liées aux consumables
     * @param message
     * @param consumable
     */
    public ConsumeException(String message, Consumables consumable){
        this.consumable = consumable;
    }

    public Consumables getConsumable(){
        return this.consumable;
    }

}