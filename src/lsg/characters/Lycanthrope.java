package lsg.characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {

	public Lycanthrope() {
		super("Lycanthrope", 210, 300);
		this.setSkinThickness(30);
		this.setWeapon(new Claw("Bloody Claw", 50, 150, 40, 112));
	}
}
