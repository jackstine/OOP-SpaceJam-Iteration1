package model;

public class HelmetSlot extends BufferSlot{
	
	public HelmetSlot(Equipment equipment){
		super(equipment);
	}

	public boolean equip(Weapon item) {
		return false;
	}

	public boolean equip(Armor armor) {
		return false;
	}

	public boolean equip(Helmet helmet) {
		return this.equipItem(helmet);
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
	

}
