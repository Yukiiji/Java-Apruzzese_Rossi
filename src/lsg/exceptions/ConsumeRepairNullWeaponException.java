package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeRepairNullWeaponException extends ConsumeException {

	/**
	 * Gère le cas où l'on essaie de réparer une arme qui n'existe pas
	 * @param consumable
	 */
    public ConsumeRepairNullWeaponException(Consumables consumable) {
        super("Trying to repair null weapon !", consumable);
    }

}