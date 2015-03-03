package model.items;

import model.slots.Equipment;
import model.slots.HunterWeaponSlot;

public class HunterWeapon extends Weapon{

	public HunterWeapon(int attack) {
		super(attack);
	}
	
	public boolean equipItem(Equipment equipment){
		return equipment.equip(this);
	}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	@Override
	public boolean equip(HunterWeaponSlot slot){
		return slot.equipItem(this);
	}
}
