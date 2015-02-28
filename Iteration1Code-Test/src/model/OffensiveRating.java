package model;


import java.util.Observable;

import model.slots.BufferSlot;

public class OffensiveRating extends DerivedStat{
	private BufferSlot slotSubject;
	private int weaponBonus;
	
	//DEPRECATED
//	public OffensiveRating(){
//		super();
//	}
	
	public OffensiveRating(BufferSlot subject){
		super();
		this.slotSubject = subject;
		this.weaponBonus = 0;
	}
	
	public void setSlotSubject(BufferSlot slot){
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
		//TODO calling inherited variables...
		int strength = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		this.value = this.weaponBonus + (strength * level);
	}
}
