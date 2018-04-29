package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character {
	
	private static int instances_count = 1;
	private float skinThickness = 20;
	private Talisman talisman;
	
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

	protected void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}
	
	protected void setTalisman(Talisman talisman) {
		this.talisman = talisman;
	}
	@Override
	public float computeProtection() {
		//TP 3 Q4.2 LEs classes présentent une erreur car la méthode abstraite de la classe abstraite doit être initialisée dans toutes les sous classes
		return this.skinThickness;
	}

	@Override
	public float computeBuff() {
		
		if (this.talisman != null) {
			return this.talisman.computeBuffValue();
		}
		return 0;
	}

}
