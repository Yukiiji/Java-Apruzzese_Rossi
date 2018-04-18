package lsg.weapons;

public class Claw extends Weapon{
	
	public Claw(String name, int minDamage, int maxDamage, int stamCost, int durability) {
		super(name, minDamage, maxDamage, stamCost, durability);
	}
	
	public Claw() {
		super();
		this.name = "Monster Claw";
		this.minDamage = 50;
		this.maxDamage = 150;
		this.stamCost = 5;
		this.durability = 100;
	}
}
