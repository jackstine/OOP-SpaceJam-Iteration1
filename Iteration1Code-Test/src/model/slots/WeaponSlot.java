package model.slots;

import model.DerivedStat;

public abstract class WeaponSlot extends BufferSlot{
	
	public WeaponSlot(){}
	
	public WeaponSlot(DerivedStat offensiveRating){
		addObserver(offensiveRating);
	}
	
	public WeaponSlot(Equipment equipment) {
		this.addObserver(equipment);
	}
    
	public String toString(){
		if (this.has()) return "Item:Weapon:" + this.bonus;
		else return "Item:Weapon:-1";
	}
}
