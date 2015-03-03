package model.items;

import model.Avatar;
import model.slots.Equipment;

public class Armor extends Equipable {
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
	
	public boolean action(Avatar avatar){
		return avatar.equip(this);
	}
	
	public boolean equipItem(Equipment equipment){
		return equipment.equip(this);
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

	public String getItemName() {
		return this.ITEM_NAME;
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
}
