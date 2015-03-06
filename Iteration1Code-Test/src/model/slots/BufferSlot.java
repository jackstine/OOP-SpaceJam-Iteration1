package model.slots;

import java.util.Observable;

import model.items.Equipable;
import model.items.TakeableItem;

public abstract class BufferSlot extends Observable {
	//TOD this should not implement, or at least the implementation should be in another abstract/class
    protected int bonus;
    
    public BufferSlot(){}
    
    public BufferSlot(Equipment equipment){
    	this.addObserver(equipment);
    }
    
    protected abstract Equipable unequipItem();
    public abstract TakeableItem get();
	public abstract int calculateBonus();
    public abstract boolean has();
    
    //BONUS BUFFER METHODS
    public final int getBonus(){
    	return this.bonus;
    }
    
    //TODO we need to have a handler that makes sure that only
    //Items of a K type can be passed hear
	public final void setBonus(){
    	this.bonus = this.calculateBonus();
    }
	
    public final void resetBonus(){
    	this.bonus = 0;
    	if (this.has()) this.bonus = this.calculateBonus();
    }
    
    public Equipable unequip(){
    	Equipable pointer = this.unequipItem();
        this.resetBonus();
        return pointer;
    }
    
    // This is used to send info to update the Observers
    protected final void send(){
        this.setBonus();
        this.setChanged();  		//notify the Observers of change
        this.notifyObservers();
    }
}
