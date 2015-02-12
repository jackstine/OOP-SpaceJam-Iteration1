package model;

public class ArmorSlot extends BufferSlot<Armor> implements Slotable<Armor> {
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
    
	public ArmorSlot(){}
    
    
    
	public String toString(){
		if (this.has()){
			return "Armor Slot with Armor of "+this.bonus;
		}
		else{
			return "This is a empty Armor Slot";
		}
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
