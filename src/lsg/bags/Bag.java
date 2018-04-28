package lsg.bags;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Bag {

	private int capacity;
	private int weight = 0;
	private HashSet<Collectible> items = new LinkedHashSet<Collectible>();
	
	public Bag(int capacity) {
		this.capacity = capacity;
	}
	
	
	//Getters
	
	public int getCapacity() {
		return capacity;
	}

	public int getWeight() {
		return weight;
	}
	
	//Methods
	
	public void push(Collectible item) {
		if (item.getWeight() > this.getCapacity() - this.getWeight()) {
			
		} else {
			this.items.add(item);
			this.weight += item.getWeight();
		}
	}
	
	public Collectible pop(Collectible item) {

		if (this.contains(item)) {
			this.items.remove(item);
			this.weight -= item.getWeight();
			return item;
		} else {
			return null;
		}
	}
	
	public boolean contains(Collectible item) {
		
		return this.items.contains(item) ? true : false;
	}
	
	public Collectible[] getItems() {
		
		Collectible[] content = new Collectible[this.capacity];
		int i = 0;
		for (Collectible collectible : this.items) {
			content[i] = collectible;
			i++;
		}
		return content;
	}
	
	public String toString() {
		
		int count = 0;
		String body = "";
		Collectible[] content = this.getItems();
 		for (int j = 0; j < content.length; j++) {
			if (content[count] != null) {
				body += content[count].toString() + " [" + content[count].getWeight() + " kg]\n";
				count ++;
			}
		}
		
		if (count == 0) {
			return this.getClass().getSimpleName() + " [ empty | " + this.getWeight() + "/" + this.getCapacity() + " kg ]";
		} else {
			String head = this.getClass().getSimpleName() + " [ "+ count +" items | " + this.getWeight() + "/" + this.getCapacity() + " kg ]\n";
			
			return head += body;
		}
	}
	
	public static void transfer(Bag from, Bag into) {
		
		Collectible[] fromContent = from.getItems();
		
		for (int i = 0; i < fromContent.length; i++) {
			if (fromContent[i] != null) {
				if (fromContent[i].getWeight() <= into.getCapacity() - into.getWeight()) {
					into.push(fromContent[i]);
					from.pop(fromContent[i]);
				}
			}
		}
	}
}
