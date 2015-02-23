package model;

public class GlovesSlot extends BufferSlot{
	
	public GlovesSlot(Equipment equipment){
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
		return this.equipItem(gloves);
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

}
