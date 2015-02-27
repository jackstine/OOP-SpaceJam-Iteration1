package model.items;

import model.Avatar;
import model.slots.AlchemistWeaponSlot;
import model.slots.Equipment;
import model.slots.HunterWeaponSlot;
import model.slots.TerminatorWeaponSlot;

public abstract class Equipable extends TakeableItem{
	
	public boolean action(Avatar avatar){
		return avatar.equipSlot(this);
	}
	
	public abstract TakeableItem equipSlot(Equipment equipment);
	
	public boolean equipWeaponSlot(TerminatorWeaponSlot t){return false;}
	public boolean equipWeaponSlot(AlchemistWeaponSlot t){return false;}
	public boolean equipWeaponSlot(HunterWeaponSlot t){return false;}
	
	public abstract int getBonus();
}
