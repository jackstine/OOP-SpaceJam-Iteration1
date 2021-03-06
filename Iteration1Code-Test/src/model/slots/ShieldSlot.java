package model.slots;

import model.items.Equipable;
import model.items.Shield;
import model.items.TakeableItem;


public class ShieldSlot extends BufferSlot{
	private Shield equippedItem;
	private TwoHandedWeaponSlot thw;
	
	public boolean equip(Shield shield){
		if(this.has()) return false;
		else if (this.thw != null && this.thw.has()) return false;
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
		if (thw != null && thw.has()){
			return thw.unequip();
		}
		else{
			Equipable temp = this.equippedItem;
			this.equippedItem = null;
			return temp;
		}
	}
	
	public void setTHW(TwoHandedWeaponSlot thw){
		this.thw = thw;
	}

	public TakeableItem get() {
		return this.equippedItem;
	}
	
	public String toString() {
		if (this.has()) return "Armor:Shield:" + this.getBonus();
		else return "Armor:Shield:-1";
	}
	
    // This is used to send info to update the Observers upon equip
    protected final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
