package lsg.consumables;

import lsg.consumables.food.*;
import lsg.consumables.drinks.*;

public class MenuBestOfV1 {
	
	public Consumables[] menu;
	
	public MenuBestOfV1() {
		this.menu = new Consumables[5];
		this.menu[0] = new Hamburger();
		this.menu[1] = new Wine(); 
		this.menu[2] = new Americain();
		this.menu[3] = new Coffee();
		this.menu[4] = new Whisky();
	}
	
	//Methodes
	
	/**
	 * Surchage de toString
	 */
	@Override
	public String toString() {
		
		String output = "";
		int index = 1;
		for (Consumables consumables : menu) {
			output += index + ": " + consumables.toString() + "\n";
			index++;
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(new MenuBestOfV1().toString());
	}
}
