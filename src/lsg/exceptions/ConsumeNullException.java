
package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeNullException extends ConsumeException {

    public ConsumeNullException(Consumables consumable) {
        super("Consumable is null", consumable);
    }
}
