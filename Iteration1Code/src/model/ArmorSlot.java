package model;


public class ArmorSlot extends BufferSlot{
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
	
	public ArmorSlot(Equipment equipment) {
		this.addObserver(equipment);
	}

	public boolean equip(Weapon item) {
		return false;
	}
	public boolean equip(Armor armor) {
		return this.equipItem(armor);
	}
	
	public String toString(){
		if (this.has()) return "Armor:" + this.bonus;
		else return "Armor:-1";
	}
}
