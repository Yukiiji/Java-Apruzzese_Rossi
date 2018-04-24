package lsg.consumables;

import lsg.consumables.food.*;
import lsg.consumables.drinks.*;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MenuBestOfV2 {
	
	private LinkedHashSet<Consumables> menu = new LinkedHashSet<Consumables>();
	
	public MenuBestOfV2() {
		this.menu.add(new Hamburger());
		this.menu.add(new Wine());
		this.menu.add(new Americain());
		this.menu.add(new Coffee());
		this.menu.add(new Whisky());
	}
	
	//Getter
	
	public LinkedHashSet<Consumables> getMenu() {
		return this.menu;
	}

	
	//Methodes
	
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
		System.out.println(new MenuBestOfV2().toString());
	}
}
