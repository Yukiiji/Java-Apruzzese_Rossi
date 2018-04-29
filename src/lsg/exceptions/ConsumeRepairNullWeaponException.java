package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeRepairNullWeaponException extends ConsumeException {

    public ConsumeRepairNullWeaponException(Consumables consumable) {
        super("Trying to repair null weapon !", consumable);
    }

}