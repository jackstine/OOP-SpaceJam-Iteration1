package model;

public class ShieldSlot extends BufferSlot{
	
	public ShieldSlot(Equipment equipment){
		super(equipment);
	}
	
	public boolean equip(Weapon item) {
		return false;
	}

	public boolean equip(Armor armor) {
		return false;
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
		return this.equipItem(shield);
	}

	public boolean equip(Boots boots) {
		return false;
	}

}
