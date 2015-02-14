package model;

import java.io.Serializable;

public class ArmorSlot extends BufferSlot<Armor> implements Slotable<Armor>, Serializable {
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
    
	public ArmorSlot(){}
    
    
    
	public String toString(){
		if (this.has()) return "Armor:" + this.bonus;
		else return "Armor:-1";
	}

    public static void main(String[] args){
        ArmorSlot slot = new ArmorSlot();
    	ArmorRating stat = new ArmorRating(0,slot);
    	slot.addObserver(stat);
        Armor armor = new Armor(15);
        //slot.equip(item);
        slot.equip(armor);
        slot.unequip();
    }
}
