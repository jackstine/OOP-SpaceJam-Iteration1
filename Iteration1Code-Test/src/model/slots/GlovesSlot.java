package model.slots;

import model.items.Equipable;
import model.items.Gloves;
import model.items.TakeableItem;


public class GlovesSlot extends BufferSlot{
	private Gloves equippedItem;
	
	public GlovesSlot(Equipment equipment){
		super(equipment);
	}
	
	public boolean equip(Gloves gloves){
		if(this.has()) return false;
		else{
			this.equippedItem = gloves;
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
		if (this.has()) return "Armor:Gloves:" + this.getBonus();
		else return "Armor:Gloves:-1";
	}
}
