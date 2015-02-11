package model;

public class Armor extends TakeableItem implements Equipable {
	protected int armor;
	
	public Armor(){}
	
	public Armor(int armor) {
		this.armor = armor;
	}
	
	//TODO thought we were going to put images in a MAP??
	public Armor(int armor, String image) {
		
	}
	
	public boolean action(Avatar avatar) {
		//TODO implement
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
