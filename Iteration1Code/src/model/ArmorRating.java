package model;

import java.util.Observable;
import java.util.Observer;

public class ArmorRating extends DerivedStat implements Observer{
	private ArmorSlot slotSubject;
	private int armorBonus;
	
	ArmorRating(int bonus,ArmorSlot subject){
		this.value = bonus;
		this.slotSubject = subject;
		subject.addObserver(this);				//Not only are we adding the Observer, we are adding the subject
		this.armorBonus = 0;	//Starts as 0
	}
	
	ArmorRating(){
		this.value = 0;
		this.slotSubject = null;
		this.armorBonus = 0;
	}
	
	public void setSlotSubject(ArmorSlot slot){
		this.slotSubject = slot;
	}	
	
	@Override
	public void update(Observable observable, Object arg) {
		if (observable == slotSubject){
			this.updatearmorBonus(slotSubject.getBonus());
		}
		else if (this.primaryStats.contains(observable)){
			//TODO add in the dervied updates
		}
		this.calculateValue();
	}
	
	//used to update The Slot Value, ported form Subjects
	public void updatearmorBonus(int value){
		//TODO do we want a negative value???
		this.armorBonus = value;
	}

	@Override
	public void calculateValue() {
		this.value = this.armorBonus;
	}
}
