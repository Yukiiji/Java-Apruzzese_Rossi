package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character {
	
	private static int instances_count = 1;
	private float skinThickness = 20;
	private Talisman talisman;
	
	/**
	 * Construit un montre avec un nom, d ela vie et de la stamina
	 * @param name
	 * @param maxLife
	 * @param maxStamina
	 */
	public Monster(String name, int maxLife, int maxStamina) {
		super(name);
		this.maxLife = maxLife;
		this.life = maxLife;
		this.maxStamina = maxStamina;
		this.stamina = maxStamina;
	}
	
	/**
	 * Construit un monstre par défaut
	 */
	public Monster() {
		super();
		this.name = "Monster_"+instances_count;
		this.life = 800;
		this.maxLife = 10;
		this.stamina = 10;
		this.maxStamina = 10;
		instances_count++;
	}

	/**
	 * Getters et setters
	 * @return
	 */
	
	protected float getSkinThickness() {
		return skinThickness;
	}

	protected void setSkinThickness(float skinThickness) {
		this.skinThickness = skinThickness;
	}
	
	protected void setTalisman(Talisman talisman) {
		this.talisman = talisman;
	}
	
	/**
	 * Methode héritée qui calcule la duretée de la peau du monstre
	 */
	@Override
	public float computeProtection() {
		//TP 3 Q4.2 LEs classes présentent une erreur car la méthode abstraite de la classe abstraite doit être initialisée dans toutes les sous classes
		return this.skinThickness;
	}
	
	/**
	 * methode héritée qui calcule le buff fourni par le talisman
	 */
	@Override
	public float computeBuff() {
		
		if (this.talisman != null) {
			return this.talisman.computeBuffValue();
		}
		return 0;
}

}
