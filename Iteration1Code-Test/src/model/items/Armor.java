package model.items;

import model.Point;
import model.slots.Equipment;
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
