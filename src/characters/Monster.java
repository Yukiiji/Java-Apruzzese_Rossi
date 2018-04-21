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

	protected float getSkinThickness() {
		return skinThickness;
	}

	protected
	void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}
	
	@Override
	public float computeProtection() {
		//TP 3 Q4.2 LEs classes pr�sentent une erreur car la m�thode abstraite de la classe abstraite doit �tre initialis�e dans toutes les sous classes
		return this.skinThickness;
	}

}
