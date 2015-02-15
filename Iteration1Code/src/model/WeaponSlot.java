package model;

public class WeaponSlot extends BufferSlot{
	
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

	public boolean equip(Weapon item) {
		return equipItem(item);
	}
	public boolean equip(Armor armor) {
		return false;
	}
}
