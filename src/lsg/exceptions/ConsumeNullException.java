
package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeNullException extends ConsumeException {

	/**
	 * Gere le cas o� le consumable n'existe pas
	 * @param consumable
	 */
    public ConsumeNullException(Consumables consumable) {
        super("Consumable is null", consumable);
    }
}
