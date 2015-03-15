package model.slots;

import model.items.Equipable;
import model.items.Leggings;
import model.items.TakeableItem;


public class LeggingsSlot extends BufferSlot{
	private Leggings equippedItem;
	
	public LeggingsSlot(Equipment equipment){
		super(equipment);
	}
	
	public boolean equip(Leggings leggings){
		if(this.has()) return false;
		else{
			this.equippedItem = leggings;
			this.send();
			return true;
		}
	}
	
	public int calculateBonus() {
		return this.equippedItem.getBonus();
	}

	public boolean has() {
		return (this.equippedItem != null);
	}

	protected Equipable unequipItem() {
		Equipable temp = this.equippedItem;
		this.equippedItem = null;
		return temp;
	}

	public TakeableItem get() {
		return this.equippedItem;
	}
	
	public String toString() {
		if (this.has()) return "Armor:Leggings:" + this.getBonus();
		else return "Armor:Leggings:-1";
	}
}
