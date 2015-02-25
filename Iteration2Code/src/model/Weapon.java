package model;

import view.EquipmentView;

public class Weapon extends Equipable {
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
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
	}
	
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
