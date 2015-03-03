package model.items;

import model.Avatar;
import model.slots.Equipment;

public abstract class Equipable extends TakeableItem{
	
	public abstract boolean action(Avatar avatar);
	
	public abstract boolean equipItem(Equipment equipment);
	
	public abstract int getBonus();
	
	public abstract void accept(EquipableVisitor visitor);
}
