package model.items;

import model.Avatar;
import model.visitor.EquipableVisitor;

public abstract class Equipable extends TakeableItem{
	
	public boolean action(Avatar avatar){
		avatar.equip(this);
		return true;
	}
	
	public abstract int getBonus();
	
	public abstract void accept(EquipableVisitor visitor);
}
