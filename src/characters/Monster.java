package characters;

public class Monster extends Character {
	
	private static int instances_count = 1;
	private float skinThickness = 20;
	
	public Monster(String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;
	}
	
	public Monster() {
		super();
		this.name = "Monster_"+instances_count;
		this.life = 800;
		this.maxLife = 10;
		this.stamina = 10;
		this.maxStamina = 10;
		instances_count++;
	}

	public float getSkinThickness() {
		return skinThickness;
	}

	public void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}
	
	

}
