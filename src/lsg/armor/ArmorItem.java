package lsg.armor;

public class ArmorItem {
	
	protected String name;
	protected float armorValue = 0;
	
	
	//Constructeur d'armure
	public ArmorItem(String name, float armorValue) {
		this.name = name;
		this.armorValue = armorValue;
	}
	
	public ArmorItem() {

	}
	

	//Getters
	public String getName() {
		return name;
	}

	public float getArmorValue() {
		return armorValue;
	}
	
	
	//Methodes
	
	public String toString() {
		return this.name+" (" + this.armorValue + ")";
	}
}
