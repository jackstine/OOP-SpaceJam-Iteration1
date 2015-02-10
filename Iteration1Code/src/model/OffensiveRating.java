package model;

import java.util.Observable;

public class OffensiveRating extends DerivedStat {
	private WeaponSlot slotSubject;
	private int weaponBonus;
	
	OffensiveRating(int bonus,WeaponSlot subject){
		this.value = bonus;
		this.slotSubject = subject;
		this.weaponBonus = 0;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if (observable == slotSubject){
			this.updateWeaponBonus(slotSubject.getBonus());
		}
		else if (this.primaryStats.contains(observable)){
			//TODO add in the dervied updates
		}
	}

	public void updateWeaponBonus(int value){
		//TODO do we want a negative value???
		this.weaponBonus = value;
	}
	
	@Override
	public void calculateValue() {
		this.value = this.weaponBonus;
	}
}
