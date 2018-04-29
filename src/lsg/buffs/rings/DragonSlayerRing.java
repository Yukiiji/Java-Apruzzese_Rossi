package lsg.buffs.rings;

import lsg.armor.ArmorItem;
import lsg.armor.DragonSlayerLeggings;

public class DragonSlayerRing extends Ring{
	
	/**
	 * Constructeur
	 */
	public DragonSlayerRing() {
		super("Dragon Slayer Ring", 14) ;
	}
	
	/**
	 * Methode abstraite qui calcule la valeur du buff selon la methode hasDragonSlayerItem
	 */
	@Override
	public float computeBuffValue() {
		if(hero != null && hasDragonsSlayerItem()){
			return power ;
		}else return 0 ;
	}
	
	/**
	 * Si le hero porte le dragon slayer leggings, alors le buff lui est accordé
	 * @return
	 */
	private boolean hasDragonsSlayerItem(){
		ArmorItem[] items = hero.getArmorItem() ;
		for(ArmorItem item: items){
			if(item instanceof DragonSlayerLeggings) return true ; 
		}
		return false ;
	}
	
}
