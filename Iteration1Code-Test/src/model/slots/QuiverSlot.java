package model.slots;

import model.items.Equipable;
import model.items.Projectile;
import model.items.TakeableItem;


public class QuiverSlot extends BufferSlot{
	private Projectile equippedItem;
	
	public QuiverSlot(Equipment equipment){
		super(equipment);
	}
	
	public boolean equip(Projectile projectile){
		if(this.has()) return false;
		else{
			this.equippedItem = projectile;
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
		if (this.has()) return "Armor:Quiver:" + this.getBonus();
		else return "Armor:Quiver:-1";
	}
	
    // This is used to send info to update the Observers upon equip
    protected final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
