package model.items;

import model.slots.BufferSlot;
import model.slots.Equipment;
import model.slots.TerminatorWeaponSlot;

public class TerminatorWeapon extends Weapon{

	public TerminatorWeapon(int attack) {
		super(attack);
	}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	public boolean equipToWeaponSlot(Equipment equipment){
		return (! equipment.equipSlot(this.slot,this));
	}
	
	public boolean equipWeaponSlot(TerminatorWeaponSlot t){return true;}
}
