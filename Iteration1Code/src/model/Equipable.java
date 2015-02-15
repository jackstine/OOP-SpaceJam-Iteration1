package model;



public abstract class Equipable extends TakeableItem implements Item{
	public abstract int getBonus();
	
	//YES...... 
	public abstract boolean equip(ArmorSlot slot);
	public abstract boolean equip(WeaponSlot slot);
}
