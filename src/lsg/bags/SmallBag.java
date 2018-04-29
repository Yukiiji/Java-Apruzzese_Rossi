package lsg.bags;

import lsg.armor.*;
import lsg.consumables.drinks.*;
import lsg.weapons.Sword;

public class SmallBag extends Bag{

	/**
	 * Constructeur
	 */
	public SmallBag() {
		super(10);
	}

	/**
	 * Main lance le programme
	 * @param args
	 */
	public static void main(String[] args) {
		
		SmallBag sb = new SmallBag();
		Bag tb = new Bag(5);
		
		DragonSlayerLeggings dsl = new DragonSlayerLeggings();
		DragonSlayerLeggings dsl2 = new DragonSlayerLeggings();
		
		sb.push(dsl);
		sb.push(dsl2);
		sb.push(new Wine());
		sb.push(new Sword("Enuma Elish", 1, 999, 50, 1000));
		
		System.out.println(sb.toString());
		System.out.println(tb.toString());
		
		System.out.println("\n");
		
		
		System.out.println("Popped 1 DSL\n");
		sb.pop(dsl);
		System.out.println(sb.toString());
		
		System.out.println("\nTransfer from Small to tiny bag\n");
		Bag.transfer(sb, tb);
		System.out.println(sb.toString());
		System.out.println(tb.toString());
	}

}
