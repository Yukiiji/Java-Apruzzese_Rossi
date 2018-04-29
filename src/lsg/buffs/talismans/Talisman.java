package lsg.buffs.talismans;

import java.util.Calendar;

import lsg.buffs.BuffItem;

public class Talisman extends BuffItem {
	
	private float buff ;
	private int start, end ; 
	
	/**
	 * Constructeur
	 * @param name
	 * @param buff
	 * @param start
	 * @param end
	 */
	public Talisman(String name, float buff, int start, int end) {
		super(name) ;
		this.buff = buff ;
		this.start = start ;
		this.end = end ;
	}
	
	/**
	 * Calcule si le buff est actif ou non, selon l'heure qu'il est et en fonction des paramètres start et end
	 */
	@Override
	public float computeBuffValue() {
		int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
		if(start <= end){
			if(now >= start && now < end) return buff ;
			else return 0f ;
		}else{
			if( (now <= 23 && now >= start) || (now >=0 && now < end)) return buff ;
			else return 0f ;
		}
	}
	
}
