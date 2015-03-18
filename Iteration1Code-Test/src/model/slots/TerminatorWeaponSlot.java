package model.slots;

import model.items.Equipable;
import model.items.TakeableItem;
import model.items.TerminatorWeapon;
import model.items.Weapon;

public class TerminatorWeaponSlot extends WeaponSlot{
	private TerminatorWeapon equippedItem;
	private TwoHandedWeaponSlot thw;
    
	public boolean equip(Weapon weapon){
		return weapon.equip(this);
	}
	
	public boolean equipItem(TerminatorWeapon weapon){
		if (this.has()) return false;
		else {
			this.equippedItem = weapon;
			this.send();
			return true;
		}
	}
	
	public boolean hasTHW(){
		if (equippedItem != null)
			return this.equippedItem.isTHW();
		else return false;
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
	
	public void drop(){
		this.equippedItem = null;
	}

	public void setTHW(TwoHandedWeaponSlot thw){
		this.thw = thw;
	}
	
	public TakeableItem get() {
		return this.equippedItem;
	}
	
	public String toString() {
		if (this.has()) return this.equippedItem.toString();
		else return "Weapon:TerminatorWeapon:-1";
	}
	
    // This is used to send info to update the Observers upon equip
    protected final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
