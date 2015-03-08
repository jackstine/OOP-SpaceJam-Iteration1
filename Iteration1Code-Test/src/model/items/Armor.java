package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

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
