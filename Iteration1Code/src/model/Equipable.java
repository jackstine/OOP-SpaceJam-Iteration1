package model;

public abstract class Equipable extends TakeableItem{
	
	public boolean action(Avatar avatar){
		TakeableItem item = this.equipSlot(avatar.getEquipment());
		boolean notEmpty = (item != null);
		if (notEmpty){
			avatar.getInventory().findAndEquip(item);
		}
		return true;
	}
	
	public abstract TakeableItem equipSlot(Equipment equipment);
	
	public abstract int getBonus();
	
	//YES...... 
	public abstract boolean equip(ArmorSlot slot);
	public abstract boolean equip(WeaponSlot slot);
	public abstract boolean equip(HelmetSlot slot);
	public abstract boolean equip(GlovesSlot slot);
	public abstract boolean equip(BootsSlot slot);
	public abstract boolean equip(LeggingsSlot slot);
	public abstract boolean equip(ShieldSlot slot);
	public abstract boolean equip(QuiverSlot slot);
}
