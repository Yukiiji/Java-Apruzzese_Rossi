package lsg.exceptions;

public class StaminaEmptyException extends Exception {

	/**
	 * Gere le cas o� le h�ro n'a plus de stamina
	 */
    public StaminaEmptyException() {
        super("no stamina !");
    }

}