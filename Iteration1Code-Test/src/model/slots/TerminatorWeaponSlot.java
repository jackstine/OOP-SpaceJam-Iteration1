package model.slots;

import model.items.Equipable;
import model.items.TakeableItem;
import model.items.TerminatorWeapon;
import model.items.Weapon;

public class TerminatorWeaponSlot extends WeaponSlot{
	private TerminatorWeapon equippedItem;
    
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
		Equipable temp = this.equippedItem;
		this.equippedItem = null;
		return temp;
	}

	public TakeableItem get() {
		return this.equippedItem;
	}
}
