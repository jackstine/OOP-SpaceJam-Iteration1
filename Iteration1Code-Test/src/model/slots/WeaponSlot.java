package model.slots;

import model.items.Weapon;
import model.stats.DerivedStat;

public abstract class WeaponSlot extends BufferSlot{
	
	public WeaponSlot(){}
	
	public WeaponSlot(DerivedStat offensiveRating){
		addObserver(offensiveRating);
	}
	
	public WeaponSlot(Equipment equipment) {
		this.addObserver(equipment);
	}
	
	public abstract boolean equip(Weapon weapon);
    
	public String toString(){
		if (this.has()) return "Item:Weapon:" + this.bonus;
		else return "Item:Weapon:-1";
	}
}
