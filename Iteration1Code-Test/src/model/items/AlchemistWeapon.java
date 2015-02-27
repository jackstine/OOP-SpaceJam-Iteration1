package model.items;

import model.slots.AlchemistWeaponSlot;
import model.slots.Equipment;

public class AlchemistWeapon extends Weapon{

	public AlchemistWeapon(int attack) {
		super(attack);
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
	public boolean equipToWeaponSlot(Equipment equipment){
		return (! equipment.equipSlot(this.slot,this));
	}
	
	public boolean equipWeaponSlot(AlchemistWeaponSlot t){return true;}
}
