package model;

public abstract class Equipable extends TakeableItem{
	
	public boolean action(Avatar avatar){
		TakeableItem item = this.equipSlot(avatar.getEquipment());
		avatar.getInventory().findAndEquip(item);
		return true;
	}
	
	public abstract TakeableItem equipSlot(Equipment equipment);
	
	public abstract int getBonus();
	
	//YES...... 
	public abstract boolean equip(ArmorSlot slot);
	public abstract boolean equip(WeaponSlot slot);
}
