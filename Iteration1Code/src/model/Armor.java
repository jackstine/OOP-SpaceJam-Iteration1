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
	}
	
	//TODO thought we were going to put images in a MAP??
	public Armor(int armor, String image) {
		this.armor = armor;
		this.ITEM_IMAGE = image;
	}
	
	public int getBonus() {
		return this.armor;
	}
	
	public String toString(){
		return "Armor:" + this.armor;
	}
	
	public static void main(String[] args){
		// testing to make sure that we can move a InventorySlot into a ArmorSlot
		ArmorSlot armorSlot = new ArmorSlot();
		InventorySlot invSlot = new InventorySlot();
		Armor armor = new Armor();
		armorSlot.equip(armor);
		invSlot.equip(armorSlot.unequip());
		//Type casting here to make it a Armor
		armorSlot.equip((Armor)invSlot.unequip());
		//armorSlot.equip(invSlot.unequip()); This will not work
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
}
