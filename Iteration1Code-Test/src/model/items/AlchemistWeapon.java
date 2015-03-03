package model.items;

import model.Avatar;
import model.slots.AlchemistWeaponSlot;
import model.slots.Equipment;

public class AlchemistWeapon extends Weapon{

	public AlchemistWeapon(int attack) {
		super(attack);
	}
	
	public boolean equipItem(Equipment equipment){
		return equipment.equip(this);
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	@Override
	public boolean equip(AlchemistWeaponSlot slot){
		return slot.equipItem(this);
	}
}
