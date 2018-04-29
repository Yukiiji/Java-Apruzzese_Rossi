package lsg.bags;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Bag {

	private int capacity;
	private int weight = 0;
	private HashSet<Collectible> items = new LinkedHashSet<Collectible>();
	
	/**
	 * Constructeur
	 * @param capacity
	 */
	public Bag(int capacity) {
		this.capacity = capacity;
	}
	
	
	//Getters
	
	/**
	 * getter
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}


	/**
	 * getter
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	//Methods
	
	/**
	 * Ajoute un objet dans le sac si il n'est pas trop lourd
	 * @param item
	 */
	public void push(Collectible item) {
		if (item.getWeight() > this.getCapacity() - this.getWeight()) {
			
		} else {
			this.items.add(item);
			this.weight += item.getWeight();
		}
	}
	
	/**
	 * Si il existe retire un objet du sac
	 * @param item
	 * @return
	 */
	public Collectible pop(Collectible item) {

		if (this.contains(item)) {
			this.items.remove(item);
			this.weight -= item.getWeight();
			return item;
		} else {
			return null;
		}
	}
	
	/**
	 * Vérifie si un objet existe dans le sac
	 * @param item
	 * @return
	 */
	public boolean contains(Collectible item) {
		
		return this.items.contains(item) ? true : false;
	}
	
	/**
	 * Retourne un tableau des objets présents dans le sac
	 * @return
	 */
	public Collectible[] getItems() {
		
		Collectible[] content = new Collectible[this.capacity];
		int i = 0;
		for (Collectible collectible : this.items) {
			content[i] = collectible;
			i++;
		}
		return content;
	}
	
	/**
	 * Surchage de toString
	 */
	@Override
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
	
	/**
	 * Transférer le sobjets d'un sac a à un sac b
	 * @param from
	 * @param into
	 */
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
