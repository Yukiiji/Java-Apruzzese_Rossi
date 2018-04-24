package lsg.consumables;

public class Consumables {
	
	private String name, stat;
	private int capacity;
	
	public Consumables(String name, int capacity, String stat) {
		this.name = name;
		this.capacity = capacity;
		this.stat = stat;
	}
	
	
	//Getters

	public String getName() {
		return name;
	}

	public String getStat() {
		return stat;
	}

	public int getCapacity() {
		return capacity;
	}
	
	
	//Setter
	
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	// Methodes

	public String toString() {
		return this.name + " [" + this.stat + " " + this.capacity + " point(s)]";
	}
	
	public int use() {
		int capacity = this.getCapacity();
		this.setCapacity(0);
		return capacity;
	}
}
