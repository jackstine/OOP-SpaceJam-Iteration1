package model.items;

import model.slots.AlchemistWeaponSlot;
import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public class AlchemistWeapon extends Weapon{

	public AlchemistWeapon(int attack) {
		super(attack);
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	@Override
	public boolean equip(AlchemistWeaponSlot slot){
		return slot.equipItem(this);
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
}
