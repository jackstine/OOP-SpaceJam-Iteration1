package model.stats;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.slots.BufferSlot;

public class ArmorRating extends DerivedStat implements Observer{
	private ArrayList<BufferSlot> slotSubjects = new ArrayList<BufferSlot>();
	private int[] armorBonusArray;
	private int armorBonus;
	
	
	//DEPRECATED
//	public ArmorRating(){
//		super();
//	}
	
	public ArmorRating(BufferSlot[] subjects){
		super();
		this.setSlotSubjects(subjects);
	}
	
	private void addSubjects(BufferSlot[] subjects){
		for (int i = 0 ; i < subjects.length ; i++){
			this.slotSubjects.add(subjects[i]);
		}
	}
	
	public void setSlotSubjects(BufferSlot[] slots){
		this.armorBonusArray = new int[slots.length];
		this.slotSubjects.clear();
		this.addSubjects(slots);
	}	
	
	@Override
	public void update(Observable observable, Object arg) {
		if (this.slotSubjects.contains(observable)){
			this.updateArmorBonus(slotSubjects.indexOf(observable));
		}
		this.calculateValue();
	}
	
	//used to update The Slot Value, ported form Subjects
	// the int is the index of the subjectSlots
	public void updateArmorBonus(int index){
		// subtract the value you are changing
		//then change it
		//then add it
		this.armorBonus -= this.armorBonusArray[index];
		this.armorBonusArray[index] = slotSubjects.get(index).getBonus();
		this.armorBonus += this.armorBonusArray[index];
	}

	@Override
	public void calculateValue() {
		int hardiness = this.stats.get(0).getValue();
		this.value = this.armorBonus + hardiness;
	}
}
