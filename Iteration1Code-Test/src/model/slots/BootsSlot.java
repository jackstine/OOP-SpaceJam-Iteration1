package model.slots;

import model.items.Boots;
import model.items.Equipable;
import model.items.TakeableItem;

public class BootsSlot extends BufferSlot{
	private Boots equippedItem;
	
	public BootsSlot(Equipment equipment){
		super(equipment);
	}
	
	public boolean equip(Boots boots){
		if(this.has()) return false;
		else{
			this.equippedItem = boots;
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
		if (this.has()) return "Armor:Boots:" + this.getBonus();
		else return "Armor:Boots:-1";
	}
}
