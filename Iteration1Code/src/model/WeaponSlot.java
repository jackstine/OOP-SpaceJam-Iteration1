package model;

public class WeaponSlot extends BufferSlot{
	public WeaponSlot(DerivedStat offensiveRating){
		addObserver(offensiveRating);
	}
	
	public WeaponSlot(){}
	
	public String toString(){
		if (this.has()) return "Weapon:" + this.bonus;
		else return "Weapon:-1";
	}

    public static void main(String[] args){
        WeaponSlot slot = new WeaponSlot();
        OffensiveRating stat = new OffensiveRating(0,slot);
    	slot.addObserver(stat);
        Weapon weapon = new Weapon(15);
        //slot.equip(item);
        slot.equip(weapon);
        slot.unequip();
    }

	public boolean equip(Weapon item) {
		return equipItem(item);
	}
	public boolean equip(Armor armor) {
		return false;
	}
}
