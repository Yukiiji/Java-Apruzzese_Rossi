
package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeEmptyException extends ConsumeException {

    public ConsumeEmptyException(Consumables consumable) {
        super("Consumable is empty", consumable);
    }

}