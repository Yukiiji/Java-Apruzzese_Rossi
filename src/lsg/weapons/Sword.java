package lsg.weapons;

public class Sword extends Weapon{
	
	/**
	 * Constructeur customisé
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Sword(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);
	}
	
	/**
	 * Constructeur par défaut
	 */
	public Sword() {
		super();
		this.name = "Basic Sword";
	}
}
