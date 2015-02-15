package model;

import java.util.Observable;

public abstract class BufferSlot extends Observable {
	//TOD this should not implement, or at least the implementation should be in another abstract/class
    protected int bonus;
    protected Equipable equippedItem;
    
    BufferSlot(){}  //should never be called except for testing purposes
    
    //BONUS BUFFER METHODS
    public int getBonus(){
    	return this.bonus;
    }
    
    //TODO we need to have a handler that makes sure that only
    //Items of a K type can be passed hear
	public <K extends Equipable> void setBonus(){
    	this.bonus = this.equippedItem.getBonus();
    }
    public void resetBonus(){
    	this.bonus = 0;
    }
    
    public boolean has(){
        if (this.equippedItem == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public Item unequip(){
        if (this.has()){
        	Equipable item = this.equippedItem;
            Item pointer = item;
            this.equippedItem = null;
            this.resetBonus();
            return pointer;
        }
        else{
            return this.equippedItem;
        }
    }
    
    public <K extends Equipable> boolean equipItem(K item){
		if (this.has()) return false;
		else {
			this.equippedItem = item;
			this.send();
			return true;
		}
    }
    
    public Item get(){
        return this.equippedItem;
    }
    
    public abstract boolean equip(Weapon item);
    public abstract boolean equip(Armor armor);
    
    public void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
