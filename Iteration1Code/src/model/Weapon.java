package model;

import view.EquipmentView;

public class Weapon extends Equipable {
	private int attack;
	protected Point slot = EquipmentView.WEAPON_POINT;
	
	public Weapon(int attack) {
		this.attack = attack;
		this.ITEM_IMAGE = "src/res/img/weapon.png";
		this.ITEM_NAME = "Weapon";
	}
	
	public Weapon(int attack, String image) {
		this.attack = attack;
		this.ITEM_IMAGE = image;
		this.ITEM_NAME = "Weapon";
	}
	
	public int getBonus() {
		return this.attack;
	}
	public String toString(){
		return "Item:Weapon:" + this.attack;
	}

	public boolean equip(ArmorSlot slot) {
		return false;
	}

	public boolean equip(WeaponSlot slot) {
		return slot.equip(this);
	}

	public TakeableItem equipSlot(Equipment equipment) {
		TakeableItem item = equipment.unequipSlot(this.slot);
		equipment.equipSlot(this.slot,this);
		return item;
	}

	@Override
	public String getItemName() {
		return this.ITEM_NAME;
	}
}
