package model.slots;

import model.items.Equipable;
import model.items.HunterWeapon;
import model.items.TakeableItem;
import model.items.Weapon;

public class HunterWeaponSlot extends WeaponSlot{
	private HunterWeapon equippedItem;
	
	public boolean equip(Weapon weapon){
		return weapon.equip(this);
	}
	
	public boolean equipItem(HunterWeapon weapon){
		if (this.has()) return false;
		else {
			this.equippedItem = weapon;
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
		if (this.has()) return this.equippedItem.toString();
		else return "Weapon:HunterWeapon:-1";
	}
}
