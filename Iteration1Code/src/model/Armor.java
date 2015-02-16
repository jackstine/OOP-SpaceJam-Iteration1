package model;

import view.EquipmentView;

public class Armor extends Equipable {
	protected int armor;
	private static String ARMOR_IMAGE = "src/res/img/armor.png";
	protected Point slot = EquipmentView.ARMOR_POINT;
	
	public Armor(){}
	 
	public Armor(int armor) {
		this.armor = armor;
		ITEM_IMAGE = ARMOR_IMAGE;
		this.ITEM_NAME = "Armor";
	}
	
	//TODO thought we were going to put images in a MAP??
	public Armor(int armor, String image) {
		this.armor = armor;
		this.ITEM_IMAGE = image;
		this.ITEM_NAME = "Armor";
	}
	
	public int getBonus() {
		return this.armor;
	}
	
	public String toString(){
		return "Item:Armor:" + this.armor;
	}

	public boolean equip(ArmorSlot slot) {
		return slot.equip(this);	
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
