package lsg.consumables.repair;

import lsg.consumables.Consumables;
import lsg.weapons.Weapon;

public class RepairKit extends Consumables{

	/**
	 * Constructeur
	 */
	public RepairKit() {
		super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
	}
	
	/**
	 * Surchage de use pour décrémenter les kits au lieu de les vider
	 */
	public int use() {
		this.setCapacity(getCapacity() - 1);
		return 1;
	}

}
