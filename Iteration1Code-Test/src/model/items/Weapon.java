package model.items;

import model.Point;
import model.slots.Equipment;
import view.EquipmentView;

public abstract class Weapon extends Equipable {
	private int attack;
	protected Point slot = EquipmentView.WEAPON_POINT;
	
	public Weapon(int attack) {
		this.attack = attack;
		this.ITEM_NAME = "Weapon";
	}
	
	public Weapon(int attack, String image) {
		this.attack = attack;
		this.ITEM_NAME = "Weapon";
	}
	
	public abstract void accept(ItemVisitor visitor);
	
	public int getBonus() {
		return this.attack;
	}
	public String toString(){
		return "Item:Weapon:" + this.attack;
	}
	
	public TakeableItem equipSlot(Equipment equipment) {
		TakeableItem item = equipment.unequipSlot(this.slot);
		equipment.equipSlot(this.slot,this);
		return item;
	}
	
	public String getItemName() {
		return this.ITEM_NAME;
	}
}
