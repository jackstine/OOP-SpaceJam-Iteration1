package model.slots;

import model.DerivedStat;


public class ArmorSlot extends BufferSlot{
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
	
	public ArmorSlot(){}

	public ArmorSlot(Equipment equipment) {
		this.addObserver(equipment);
	}
	
	public String toString(){
		if (this.has()) return "Item:Armor:" + this.bonus;
		else return "Item:Armor:-1";
	}
}
