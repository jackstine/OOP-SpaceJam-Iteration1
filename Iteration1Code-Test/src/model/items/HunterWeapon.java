package model.items;

import model.slots.Equipment;
import model.slots.HunterWeaponSlot;

public class HunterWeapon extends Weapon{

	public HunterWeapon(int attack) {
		super(attack);
	}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	public boolean equipToWeaponSlot(Equipment equipment){
		return (! equipment.equipSlot(this.slot,this));
	}
	
	public boolean equipWeaponSlot(HunterWeaponSlot t){return true;}
}
