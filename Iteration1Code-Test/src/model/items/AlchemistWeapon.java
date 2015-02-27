package model.items;

import model.slots.AlchemistWeaponSlot;

public class AlchemistWeapon extends Weapon{

	public AlchemistWeapon(int attack) {
		super(attack);
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	public boolean equipWeaponSlot(AlchemistWeaponSlot t){return true;}
}
