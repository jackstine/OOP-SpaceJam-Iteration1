package model.slots;

import java.util.Observable;

import model.items.Equipable;
import model.items.TakeableItem;

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
	public final void setBonus(){
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
    
    public Equipable unequip(){
        if (this.has()){
        	Equipable item = this.equippedItem;
            Equipable pointer = item;
            this.equippedItem = null;
            this.resetBonus();
            return pointer;
        }
        else{
            return this.equippedItem;
        }
    }
    
    //because we use Point system we do not need a equip(EquipableType<K>)
    //in each of the subclasses.  The only distinction is that anyType of
    //equipable can be equiped to the slot. If we instead left the equippedItem
    //then we would need to declare a boolean function equip(EquipType<K>) for 
    //each type of item and make this function a template
    protected <K extends Equipable> boolean equipItem(K item){
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
    
    // This is used to send info to update the Observers
    public final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
