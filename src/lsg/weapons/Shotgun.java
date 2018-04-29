package lsg.weapons;

public class Shotgun extends Weapon{
	
	/**
	 * Constructeur customis�
	 * @param name
	 * @param minDamage
	 * @param maxDamage
	 * @param stamCost
	 * @param durability
	 */
	public Shotgun(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);
	}
	
	/**
	 * Constructeur par d�faut
	 */
	public Shotgun() {
		super();
		this.name = "Low cost Shotgun";
		this.minDamage = 6;
		this.maxDamage = 20;
		this.stamCost = 5;
		this.durability = 100;
	}
}
