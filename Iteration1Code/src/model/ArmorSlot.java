package model;


public class ArmorSlot extends BufferSlot{
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
	
	public ArmorSlot(){}

	public ArmorSlot(Equipment equipment) {
		this.addObserver(equipment);
	}

	public boolean equip(Weapon item) {
		return false;
	}
	public boolean equip(Armor armor) {
		return this.equipItem(armor);
	}
	
	public boolean equip(Helmet helmet) {
		return false;
	}

	public boolean equip(Gloves gloves) {
		return false;
	}

	public boolean equip(Leggings leggings) {
		return false;
	}

	public boolean equip(Shield shield) {
		return false;
	}

	public boolean equip(Boots boots) {
		return false;
	}
	public boolean equip(Projectile projectile){
		return false;
	}
	
	public String toString(){
		if (this.has()) return "Item:Armor:" + this.bonus;
		else return "Item:Armor:-1";
	}
}
