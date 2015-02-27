package model.slots;

import model.items.TakeableItem;

public class BarterSlot {
	private InventorySlot slot = new InventorySlot();
	
	public BarterSlot(){}
	public BarterSlot(TakeableItem item){
		this.slot.equip(item);
	}
	
	public int getPrice(){
		return 1;
	}
	
	//Money needs to be a parameter in the buy() method
	public TakeableItem buy(){
		return this.slot.unequip();
	}
	
	public boolean has(){
		return this.has();
	}
	
	// needs to take a item and return the amount of the item
	public int sell(TakeableItem item){
		this.slot.equip(item);
		return 1;
	}

}
