package model;

public class QuiverSlot extends BufferSlot{
	
	public QuiverSlot(Equipment equipment){
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
		return false;
	}

	public boolean equip(Boots boots) {
		return false;
	}
	
	public boolean equip(Projectile projectile){
		return this.equipItem(projectile);
	}

}
