
package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeEmptyException extends ConsumeException {

	/**
	 * Gere les cas où le consumable est vide
	 * @param consumable
	 */
    public ConsumeEmptyException(Consumables consumable) {
        super("Consumable is empty", consumable);
    }

}