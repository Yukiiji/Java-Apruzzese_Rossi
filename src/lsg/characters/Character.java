package lsg.characters;
import lsg.consumables.food.*;
import lsg.consumables.repair.RepairKit;
import lsg.bags.*;
import lsg.consumables.*;
import lsg.consumables.drinks.*;
import lsg.helpers.Dice;
import lsg.weapons.Weapon;

public abstract class Character {
	
	//Variables de classe
	
	protected String name;
	
	protected int stamina, maxStamina;
	protected int life, maxLife;
	
	protected Dice dice;
	protected Weapon weapon;
	protected Consumables consumable;
	
	private Bag bag;
	
	public static final String LIFE_STAT_STRING = "LIFE : ";
	public static final String STAM_STAT_STRING = "STAMINA : ";
	public static final String DEF_STAT_STRING = "DEFENSE : ";
	
	//Constructeur avec nom. Si un character est créé avec un nom passé en paramètre, on appelle d'abord le constructeur sans paramètre avec this()
	// puis on s'occuper de set le nom
	public Character (String name) {
		this();
		this.name = name;
	}
	
	//Constructeur de base
	public Character() {
		dice = new Dice(101);
		this.bag = new SmallBag();
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

	public Consumables getConsumable() {
		return consumable;
	}

	public void setConsumable(Consumables consumable) {
		this.consumable = consumable;
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
			return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-30s", this.name) + String.format("%-20s", this.LIFE_STAT_STRING + this.life) + String.format("%-30s", this.DEF_STAT_STRING + this.computeProtection()) + String.format("%-20s", this.STAM_STAT_STRING + this.stamina) + String.format("%-30s", "BUFF : " + this.computeBuff()) + String.format("%-20s", "Dead");
		}
		return String.format("%-20s", "[" + this.getClass().getSimpleName() + "]") + String.format("%-30s", this.name) + String.format("%-20s", this.LIFE_STAT_STRING + this.life) + String.format("%-30s", this.DEF_STAT_STRING + this.computeProtection()) + String.format("%-20s", this.STAM_STAT_STRING + this.stamina)+ String.format("%-30s", "BUFF : " + this.computeBuff()) + String.format("%-20s", "Alive");
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
		
		float buffToDamage = (float) ((this.computeBuff() / 100) * damage);
		damage += (int) buffToDamage;

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
	public abstract float computeBuff();
	
	public void battle(Character foe) {
		int damage = this.attack();
		int damageAfterProtecc = foe.getHitWith(damage);
		System.out.println();
		System.out.println("°°° " + this.name + " attaque "+ foe.name +" avec "+ this.getWeapon() + "°°°");
		System.out.println("ATTACK : " + damage + " | " + foe.name + " DAMAGE TAKEN : " + damageAfterProtecc);
		System.out.println("Il reste " +foe.getLife()+" PV à "+ foe.name);
		System.out.println("\n");
	}
	
	
	public void use(Consumables consumable) {
		
		if (consumable instanceof Drink) {
			this.drink((Drink) consumable);
		}
		if (consumable instanceof Food) {
			this.eat((Food) consumable);
		}
		if (consumable instanceof RepairKit) {
			this.repairWeaponWith((RepairKit) consumable);
		}
	}
	
	private int drink(Drink drink) {
		
		System.out.println(this.name + " drinks " + drink);
		
		int oldStam = this.getStamina();
		int regenPower = drink.use();
		if (oldStam + regenPower > this.getMaxStamina()) {
			this.setStamina(this.getMaxStamina());
			return this.computeRecovered(oldStam, regenPower, this.getMaxStamina());
		}
		this.setStamina(this.getStamina() + regenPower);
		return regenPower;
	}
	
	private int eat(Food food) {
		
		System.out.println(this.name + " eats " + food);
		
		int oldLife = this.getLife();
		int regenPower = food.use();
		if (oldLife + regenPower > this.getMaxLife()) {
			this.setLife(this.getMaxLife());
			return this.computeRecovered(oldLife, regenPower, this.getMaxLife());
		}
		this.setLife(this.getLife() + regenPower);
		return regenPower;
	}
	
	private int computeRecovered(int old, int regenPower, int max) {
		int temp = (old + regenPower) - max;
		return regenPower - temp;
	}
	
	public void consume() {
		this.use(this.getConsumable());
	}
	
	private void repairWeaponWith(RepairKit kit) {
		System.out.println(this.name + " repairs " + this.getWeapon().toString() + " with " + kit.toString());
		this.getWeapon().setDurability(this.getWeapon().getDurability() + kit.use());
	}
	
	
	public void pickUp(Collectible item) {
		if (item.getWeight() <= this.bag.getCapacity() - this.bag.getWeight()) {
			this.bag.push(item);
			System.out.println(this.getName() + " picked up " + item.toString());
		}
	}
	
	public Collectible pullOut(Collectible item) {
		Collectible pull = this.bag.pop(item);
		if (pull != null) {
			System.out.println(this.getName() + " pulls out " + item.toString());
			return pull;
		}
		return null;
	}
	
	public void printBag() {
		System.out.println(this.bag.toString());
	}
	
	public int getBagCapacity() {
		return this.bag.getCapacity();
	}
	
	public int getBagWeighth() {
		return this.bag.getCapacity() - this.bag.getWeight();
	}
	
	public Collectible[] getBagItems() {
		return this.bag.getItems();
	}
	
	public Bag setBag(Bag bag) {
		Bag.transfer(this.bag, bag);
		Bag oldBag = this.bag;
		this.bag = bag;
		System.out.println(this.name + " change " + oldBag.getClass().getSimpleName() + " to " + this.bag);
		return oldBag;
	}
	
	public void equip(Weapon weapon) {
		if (this.bag.pop(weapon) != null) {
			this.setWeapon(weapon);
			System.out.println(this.getName() + " pulls out " + weapon.toString() + " and equips it !");
		}
	}
	
	public void equip(Consumables consumable) {
		if (this.bag.pop(consumable) != null) {
			this.setConsumable(consumable);
			System.out.println(this.getName() + " pulls out " + consumable.toString() + " and equips it !");
		}
	}
	
	private Consumables fastUseFirst(Class<? extends Consumables> type) {
		
		Consumables used = null;
		String action = "";
		
        for (Collectible c : this.bag.getItems()) {
        	
            if (type.isInstance(c)) {
                this.use((Consumables) c);
                
                if (c instanceof Food) {
					action = " eats ";
				}
                if (c instanceof Drink) {
					action = " drinks ";
				}
                if (c instanceof RepairKit) {
					action = " repairs ";
				}
                System.out.println(this.name + action + c.toString());
                if (((Consumables) c).getCapacity() <= 0)
                    this.pullOut(c);
                System.out.println(this.name + " pulls out " + c.toString());
                used = (Consumables) c;
            }
        }
        return used;
	}
	
    public RepairKit fastRepair() {
        return (RepairKit)this.fastUseFirst(RepairKit.class);
    }
    
    public Food fastEat() {
        return (Food)this.fastUseFirst(Food.class);
    }
    
    public Drink fastDrink() {
        return (Drink)this.fastUseFirst(Drink.class);
    }
}
