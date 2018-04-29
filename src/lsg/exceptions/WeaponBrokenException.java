package lsg.exceptions;

import lsg.weapons.Weapon;


public class WeaponBrokenException extends Exception {

    private Weapon brokenWeapon;

    /**
     * Gere le cas ou l'arme est brisée
     * @param weapon
     */
    public WeaponBrokenException(Weapon weapon) {
        super(weapon.getName() + " is broken !");
        this.brokenWeapon = weapon;
    }

    public Weapon getBrokenWeapon () {
        return this.brokenWeapon;
    }

}