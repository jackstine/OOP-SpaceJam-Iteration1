package model.slots;

import model.items.Armor;
import model.items.Boots;
import model.items.Equipable;
import model.items.EquipableVisitor;
import model.items.Gloves;
import model.items.Helmet;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.Weapon;

public class EquipVisitor implements EquipableVisitor{
	private Equipment equipment;
	private Equipable itemToExchange;
	
//	private void equip()
//
//	public void accept(Helmet helmet){
//		if(this.equipment.getSlot(this.equipment.HELMET_SLOT).has()){
//			this.itemToExchange = this.equipment.unequipSlot(this.equipment.HELMET_SLOT);
//			this.equipment.equip(helmet);
//		} else{
//			this.equipment.equip(helmet);
//		}
//	}
//
//	public void accept(Weapon weapon){ 
//		if (this.weapon.canEquip(this.equipment.getSlot(this.equipment.WEAPON_SLOT)))
//	}

	public void accept(Armor armor){
	}

	public void accept(Leggings leggings){
	}

	public void accept(Boots boots){
	}
	
	public void accept(Gloves gloves){
	}

	public void accept(Projectile projectile){
	}
	
	public void accept(Shield shield){}

	@Override
	public void accept(Helmet helmet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Weapon weapon) {
		// TODO Auto-generated method stub
		
	}

}
