package lsg;

import java.util.Scanner;

import lsg.characters.*;
import lsg.armor.*;
import lsg.helpers.*;
import lsg.weapons.*;

public class LearningSoulsGame {
	
	//On instancie notre héros et notre monstre
	Hero hero = new Hero("Le chevalier Couscous", 250, 100);
	Monster monster = new Monster("Gilles de Rais", 300, 70);
	//On instancie un nouveau scanner pour enregistrer les entrées utilisateur
	Scanner scan = new Scanner(System.in);

		//Main : ce qui se lance lors de la compilation
	public static void main(String[] args) {
		
		//ON créée une nouvelle instance de cette classe pour pouvoir appeler ses méthodes (elles ne sont pas statique alors que le main oui)
		//On appelle la fonction play_v1() qui va se lancer au démarrage du programme
		new LearningSoulsGame().play_v3();
		
	}
	
		//Fonction qui affiche les stats du héros et du monstre
	public void refresh() {
		this.hero.printStats();
		this.monster.printStats();
	}
	
	//tant que les héros et monstre sont en vie, on affiche leurs stats avec refresh -> le heros attaque -> on attends la saisie utilisateur
	// -> On check si  lemonstre est toujours en vie après l'attaque -> On fait pareil mais avec le monstre qui attaque
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
	
	// Cette méthode va set les armes de nos personnages
	public void init() {
		this.hero.setWeapon(new Sword("La couscoussière", 60, 100, 15, 100));
		this.monster.setWeapon(new Claw("La jugulaire", 25, 125, 9, 175));
	}
	
	//Cette méthode est appelée dans le main. D'abord on appelle init() pour set les armes, ensuite on appelle fight1v1() pour les faire se totocher
	public void play_v1() {
		init();
		fight1v1();
	}
	
	public void play_v2() {
		this.hero.setArmorItem(new RingedKnightArmor(), 1);
		this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
		init();
		fight1v1();
	}
	
	public void play_v3() {
		this.hero.setArmorItem(new RingedKnightArmor(), 1);
		this.hero.setArmorItem(new DragonSlayerLeggings(), 2);
		this.monster = new Lycanthrope();
		init();
		fight1v1();
	}

}
