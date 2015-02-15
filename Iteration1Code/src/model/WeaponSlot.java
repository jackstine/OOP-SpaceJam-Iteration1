package model;

public class WeaponSlot extends BufferSlot{
	public WeaponSlot(DerivedStat offensiveRating){
		addObserver(offensiveRating);
	}
	
	public WeaponSlot(Equipment equipment) {
		this.addObserver(equipment);
	}

	public String toString(){
		if (this.has()) return "Weapon:" + this.bonus;
		else return "Weapon:-1";
	}

	public boolean equip(Weapon item) {
		return equipItem(item);
	}
	public boolean equip(Armor armor) {
		return false;
	}
}
