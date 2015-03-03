package model.slots;

import model.items.Equipable;
import model.items.Helmet;
import model.items.TakeableItem;

public class HelmetSlot extends BufferSlot{
	private Helmet equippedItem;
	
	public HelmetSlot(Equipment equipment){
		super(equipment);
	}
	
	public boolean equip(Helmet helmet){
		if(this.has()) return false;
		else{
			this.equippedItem = helmet;
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
}
