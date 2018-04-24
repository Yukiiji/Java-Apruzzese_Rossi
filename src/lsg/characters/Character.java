package lsg.characters;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public abstract class Character {
	
	//Variables de classe
	
	protected String name;
	
	protected int stamina, maxStamina;
	protected int life, maxLife;
	
	protected Dice dice;
	protected Weapon weapon;
	
	protected final String LIFE_STAT_STRING = "LIFE : ";
	protected final String STAM_STAT_STRING = "STAMINA : ";
	protected final String DEF_STAT_STRING = "DEFENSE : ";
	
	//Constructeur avec nom. Si un character est créé avec un nom passé en paramètre, on appelle d'abord le constructeur sans paramètre avec this()
	// puis on s'occuper de set le nom
	public Character (String name) {
		this();
		this.name = name;
	}
	
	//Constructeur de base
	public Character() {
		dice = new Dice(101);
	}
	

	
	//Setters et Getters
	
	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
	// Methods

	public void printStats() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		if(this.isAlive() == false) {
			return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-30s", this.name) + String.format("%-20s", this.LIFE_STAT_STRING + this.life) + String.format("%-30s", this.DEF_STAT_STRING + this.computeProtection()) + String.format("%-20s", this.STAM_STAT_STRING + this.stamina) + String.format("%-20s", "Dead");
		}
		return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-30s", this.name) + String.format("%-20s", this.LIFE_STAT_STRING + this.life) + String.format("%-30s", this.DEF_STAT_STRING + this.computeProtection()) + String.format("%-20s", this.STAM_STAT_STRING + this.stamina) + String.format("%-20s", "Alive");
	}
	
	public Boolean isAlive(){
		return this.life <= 0 ? false : true;
	}
	
	public int attack() {
		return attackWith(this.weapon);
	}
	
	private int attackWith(Weapon weapon) {
		int damage = 0;
		double multiplier = 0.0;
		if (weapon.isBroken()) {
			return 0;
		}
		
		//int staminaAfterHit = (this.stamina * 100) / weapon.getStamCost();
		int rollToDamage = (this.dice.roll() * (weapon.getMaxDamage()-weapon.getMinDamage())) / 100;
		damage = (weapon.getMinDamage() + Math.round(rollToDamage));
		if (this.stamina < weapon.getStamCost()) {
			multiplier = damage *((double)this.stamina / (double)weapon.getStamCost());
			damage = (int)multiplier;
		}
		

		weapon.setDurability(weapon.getDurability()-1);
		this.stamina -= weapon.getStamCost();
		
		if(this.stamina < 0) {
			this.stamina = 0;
		}
		
		return damage;
	}
	
	public int getHitWith(int damage) {
		//Calcul des dommages en fonction de l'armure
		int divider = damage * Math.round(this.computeProtection()) / 100;
		int damageAfterProtecc = damage - divider;
		
		int remainingLife = this.getLife() - damageAfterProtecc;
		remainingLife = remainingLife <= 0 ? 0 : remainingLife;
		this.setLife(remainingLife);
		return damageAfterProtecc;
	}
	
	public abstract float computeProtection();
	
	public void battle(Character foe) {
		int damage = this.attack();
		int damageAfterProtecc = foe.getHitWith(damage);
		System.out.println();
		System.out.println("°°° " + this.name + " attaque "+ foe.name +" avec "+ this.getWeapon() + "°°°");
		System.out.println("ATTACK : " + damage + " | " + foe.name + " DAMAGE TAKEN : " + damageAfterProtecc);
		System.out.println("Il reste " +foe.getLife()+" PV à "+ foe.name);
		System.out.println("\n");
	}
}
