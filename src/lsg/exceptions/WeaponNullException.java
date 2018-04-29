package lsg.exceptions;

public class WeaponNullException extends Exception{

	/**
	 * Gere le cas où l"arme n'existe pas
	 */
	public WeaponNullException() {
		super("No weapon !");
	}

}
