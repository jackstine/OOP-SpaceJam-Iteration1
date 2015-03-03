package model.slots;

import model.items.Equipable;
import model.items.Shield;
import model.items.TakeableItem;


public class ShieldSlot extends BufferSlot{
	private Shield equippedItem;
	
	public boolean equip(Shield shield){
		if(this.has()) return false;
		else{
			this.equippedItem = shield;
			this.send();
			return true;
		}
	}
	
	public ShieldSlot(Equipment equipment){
		super(equipment);
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
}
