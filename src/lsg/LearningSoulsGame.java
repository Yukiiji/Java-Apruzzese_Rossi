package lsg;

import java.util.Scanner;

import characters.Hero;
import characters.Monster;
import lsg.helpers.*;
import lsg.weapons.*;

public class LearningSoulsGame {
	Hero hero = new Hero("Le chevalier Couscous", 250, 100);
	Monster monster = new Monster("Gilles de Rais", 300, 70);
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dice d = new Dice(50);
		
		new LearningSoulsGame().play_v1();
		
	}
	
	public void refresh() {
		this.hero.printStats();
		this.monster.printStats();
	}
	
	public int fight1v1() {
		while (this.hero.isAlive() && this.monster.isAlive()) {
			refresh();
			this.hero.battle(this.monster);
			String str = scan.nextLine();
			if (!this.monster.isAlive()) {
				System.out.println(this.hero.getName() + " est victorieux !");
				return 0;
			}
			
			refresh();
			this.monster.battle(this.hero);
			str = scan.nextLine();
			if (!this.hero.isAlive()) {
				System.out.println(this.monster.getName() + " vous a mangé ...");
				return 0;
			}
		}
		return 0;
	}
	
	public void init() {
		this.hero.setWeapon(new Sword("La couscoussière", 60, 100, 15, 100));
		this.monster.setWeapon(new Claw("La jugulaire", 25, 125, 9, 175));
	}
	
	public void play_v1() {
		init();
		fight1v1();
	}

}
