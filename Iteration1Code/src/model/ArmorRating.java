package model;

import java.util.Observable;
import java.util.Observer;

public class ArmorRating extends DerivedStat implements Observer{
	private ArmorSlot slotSubject;
	private int armorBonus;
	
	ArmorRating(int bonus,ArmorSlot subject){
		this.value = bonus;
		this.slotSubject = subject;
		this.armorBonus = 0;	//Starts as 0
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		if (observable == slotSubject){
			this.updatearmorBonus(slotSubject.getBonus());
		}
		else if (this.primaryStats.contains(observable)){
			//TODO add in the dervied updates
		}
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
