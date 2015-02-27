package model.items;

import model.slots.HunterWeaponSlot;

public class HunterWeapon extends Weapon{

	public HunterWeapon(int attack) {
		super(attack);
	}

	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	public boolean equipWeaponSlot(HunterWeaponSlot t){return true;}
}
