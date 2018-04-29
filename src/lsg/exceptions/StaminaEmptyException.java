package lsg.exceptions;

public class StaminaEmptyException extends Exception {

	/**
	 * Gere le cas où le héro n'a plus de stamina
	 */
    public StaminaEmptyException() {
        super("no stamina !");
    }

}