package model;

import java.util.Observable;
import java.util.Observer;

public class ArmorRating extends DerivedStat implements Observer{
	private ArmorSlot slotSubject;
	private int armorBonus;
	
	public ArmorRating(){
		super();
	}
	
	public ArmorRating(int initialValue ,ArmorSlot subject){
		this.value = initialValue;
		this.slotSubject = subject;
		subject.addObserver(this);	//Not only are we adding the Observer, we are adding the subject
		this.armorBonus = 0;	    //Starts as 0
	}
	
	public void setSlotSubject(ArmorSlot slot){
		this.slotSubject = slot;
	}	
	
	@Override
	public void update(Observable observable, Object arg) {
		if (observable == slotSubject){
			this.updateArmorBonus(slotSubject.getBonus());
		}
		this.calculateValue();
	}
	
	//used to update The Slot Value, ported form Subjects
	public void updateArmorBonus(int value){
		//TODO do we want a negative value???
		this.armorBonus = value;
	}

	@Override
	public void calculateValue() {
		int hardiness = this.stats.get(0).getValue();
		this.value = this.armorBonus + hardiness;
	}
}
