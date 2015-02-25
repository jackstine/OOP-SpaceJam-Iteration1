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
}
