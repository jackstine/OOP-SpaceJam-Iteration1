package model.items;

import model.slots.TerminatorWeaponSlot;

public abstract class TerminatorWeapon extends Weapon{

	public TerminatorWeapon(int attack) {
		super(attack);
	}
	
	public boolean isTHW(){
		return false;
	}

	public boolean equip(TerminatorWeaponSlot slot){
		return slot.equipItem(this);
	}
}
