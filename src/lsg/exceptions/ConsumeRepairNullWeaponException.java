package lsg.exceptions;

import lsg.consumables.Consumables;


public class ConsumeRepairNullWeaponException extends ConsumeException {

	/**
	 * G�re le cas o� l'on essaie de r�parer une arme qui n'existe pas
	 * @param consumable
	 */
    public ConsumeRepairNullWeaponException(Consumables consumable) {
        super("Trying to repair null weapon !", consumable);
    }

}