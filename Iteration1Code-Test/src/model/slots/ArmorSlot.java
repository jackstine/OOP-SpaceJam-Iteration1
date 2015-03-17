package model.slots;

import model.items.Armor;
import model.items.Equipable;
import model.items.TakeableItem;
import model.stats.DerivedStat;


public class ArmorSlot extends BufferSlot{
	private Armor equippedItem;
    
	public ArmorSlot(DerivedStat armorRating){
    	this.addObserver(armorRating);
    }
	
	public ArmorSlot(){}
	
	public boolean equip(Armor armor){
		if(this.has()) return false;
		else{
			this.equippedItem = armor;
			this.send();
			return true;
		}
	}

	public ArmorSlot(Equipment equipment) {
		this.addObserver(equipment);
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
	
	public String toString(){
		if (this.has()) return "Armor:Chest:" + this.bonus;
		else return "Armor:Chest:-1";
	}
	
    // This is used to send info to update the Observers upon equip
    protected final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
