package model.items;

import model.slots.AlchemistWeaponSlot;
import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;
import model.visitor.WeaponVisitor;

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
	
	public String toString() {
		return "Weapon:AlchemistWeapon:" + this.getBonus();
	}
	
	public void accept(WeaponVisitor visitor) {
		visitor.accept(this);
	}
}
