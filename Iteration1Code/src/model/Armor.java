package model;

import java.io.Serializable;

import utilities.ImagePaths;

public class Armor extends TakeableItem implements Equipable, Serializable {
	protected int armor;
	private static String ARMOR_IMAGE = "src/res/img/armor.png";

	@Override
	public void action(Entity entity) {
		// TODO Auto-generated method stub
		
	}
	
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
	
	public boolean action(Avatar avatar) {
		//TODO
		return true;
	}
	
	public int getBonus() {
		return this.armor;
	}
	
	public String toString(){
		return "Armor with armor of "+this.armor;
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
}
