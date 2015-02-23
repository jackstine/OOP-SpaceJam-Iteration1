package model;

import java.util.Observable;

public abstract class BufferSlot extends Observable {
	//TOD this should not implement, or at least the implementation should be in another abstract/class
    protected int bonus;
    protected Equipable equippedItem;
    
    public BufferSlot(){}
    
    public BufferSlot(Equipment equipment){
    	this.addObserver(equipment);
    }
    
    //BONUS BUFFER METHODS
    public final int getBonus(){
    	return this.bonus;
    }
    
    //TODO we need to have a handler that makes sure that only
    //Items of a K type can be passed hear
	public final <K extends Equipable> void setBonus(){
    	this.bonus = this.equippedItem.getBonus();
    }
    public final void resetBonus(){
    	this.bonus = 0;
    }
    
    public final boolean has(){
        if (this.equippedItem == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public TakeableItem unequip(){
        if (this.has()){
        	Equipable item = this.equippedItem;
            TakeableItem pointer = item;
            this.equippedItem = null;
            this.resetBonus();
            return pointer;
        }
        else{
            return this.equippedItem;
        }
    }
    
    protected final <K extends Equipable> boolean equipItem(K item){
		if (this.has()) return false;
		else {
			this.equippedItem = item;
			this.send();
			return true;
		}
    }
    
    public final TakeableItem get(){
        return this.equippedItem;
    }
    
    public abstract boolean equip(Weapon item);
    public abstract boolean equip(Armor armor);
    public abstract boolean equip(Helmet helmet);
    public abstract boolean equip(Gloves gloves);
    public abstract boolean equip(Leggings leggings);
    public abstract boolean equip(Shield shield);
    public abstract boolean equip(Boots boots);
    
    // This is used to send info to update the Observers
    public final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
