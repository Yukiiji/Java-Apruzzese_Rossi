package lsg.exceptions;

import lsg.weapons.Weapon;


public class WeaponBrokenException extends Exception {

    private Weapon brokenWeapon;

    public WeaponBrokenException(Weapon weapon) {
        super(weapon.getName() + " is broken !");
        this.brokenWeapon = weapon;
    }

    public Weapon getBrokenWeapon () {
        return this.brokenWeapon;
    }

}