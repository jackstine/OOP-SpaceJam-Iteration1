package model.items;

import model.slots.HunterWeaponSlot;
import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public class HunterWeapon extends Weapon{

	public HunterWeapon(int attack) {
		super(attack);
	}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	@Override
	public boolean equip(HunterWeaponSlot slot){
		return slot.equipItem(this);
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
	
	public String toString() {
		return "Weapon:HunterWeapon:" + this.getBonus();
	}
}
