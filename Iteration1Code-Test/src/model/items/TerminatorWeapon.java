package model.items;

import model.slots.Equipment;
import model.slots.TerminatorWeaponSlot;

public abstract class TerminatorWeapon extends Weapon{

	public TerminatorWeapon(int attack) {
		super(attack);
	}
	
	public boolean isTHW(){
		return false;
	}
	
	public boolean equipItem(Equipment equipment){
		return equipment.equip(this);
	}

	public boolean equip(TerminatorWeaponSlot slot){
		return slot.equipItem(this);
	}
}
