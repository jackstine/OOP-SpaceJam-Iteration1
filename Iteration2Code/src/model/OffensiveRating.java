package model;


import java.util.Observable;

public class OffensiveRating extends DerivedStat{
	private WeaponSlot slotSubject;
	private int weaponBonus;
	
	public OffensiveRating(){
		super();
	}
	
	public OffensiveRating(int initialValue, WeaponSlot subject){
		this.value = initialValue;
		this.slotSubject = subject;
		this.weaponBonus = 0;
	}
	
	public void setSlotSubject(WeaponSlot slot){
		this.slotSubject = slot;
	}	
	
	@Override
	public void update(Observable observable, Object arg) {
		if (observable == slotSubject){
			this.updateWeaponBonus(slotSubject.getBonus());
		}
		this.calculateValue();
	}

	public void updateWeaponBonus(int value){
		//TODO do we want a negative value???
		this.weaponBonus = value;
	}
	
	@Override
	public void calculateValue() {
		int strength = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		this.value = this.weaponBonus + (strength * level);
	}
}
