package lsg.weapons;

public class Claw extends Weapon{
	
	/**
	 * Constructeur customisé
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Claw(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);
	}
	
	/**
	 * Constructeur par défaut
	 */
	public Claw() {
		super();
		this.name = "Monster Claw";
		this.minDamage = 50;
		this.maxDamage = 150;
		this.stamCost = 5;
		this.durability = 100;
	}
}
