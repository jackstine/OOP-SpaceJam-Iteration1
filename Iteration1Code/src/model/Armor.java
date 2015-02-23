package model;

import view.EquipmentView;

public class Armor extends Equipable {
	protected final static Point SLOT = EquipmentView.ARMOR_POINT;
	
	protected int armor;
	
	public Armor(){}
	 
	public Armor(int armor) {
		this.armor = armor;
		this.ITEM_NAME = "Armor";
	}
	
	//TODO thought we were going to put images in a MAP??
	public Armor(int armor, String image) {
		this.armor = armor;
		this.ITEM_NAME = "Armor";
	}
	
	public void accept(ItemVisitor visitor){
		visitor.accept(this);
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
	public boolean equip(HelmetSlot slot){
		return false;
	}
	public boolean equip(BootsSlot slot){
		return false;
	}
	public boolean equip(ShieldSlot slot){
		return false;
	}
	public boolean equip(LeggingsSlot slot){
		return false;
	}
	public boolean equip(GlovesSlot slot){
		return false;
	}
	
	public TakeableItem equipSlot(Equipment equipment) {
		TakeableItem item = equipment.unequipSlot(SLOT);
		equipment.equipSlot(SLOT,this);
		return item;
	}

	@Override
	public String getItemName() {
		return this.ITEM_NAME;
	}
}
