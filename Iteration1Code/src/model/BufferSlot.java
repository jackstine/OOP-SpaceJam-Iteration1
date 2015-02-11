package model;

import java.util.Observable;

public abstract class BufferSlot<T extends Item> extends Observable implements Slotable<T>{
	//TOD this should not implement, or at least the implementation should be in another abstract/class
    protected T item;
    protected int bonus;
    
    BufferSlot(){}  //should never be called except for testing purposes
    
    //BONUS BUFFER METHODS
    public int getBonus(){
    	return this.bonus;
    }
    
    //TODO we need to have a handler that makes sure that only
    //Items of a K type can be passed hear
    @SuppressWarnings("unchecked")
	public <K extends Equipable> void setBonus(){
    	this.bonus = ((K)this.item).getBonus();
    }
    public void resetBonus(){
    	this.bonus = 0;
    }
    
    public boolean has(){
        if (this.item == null){
            return false;
        }
        else{
            return true;
        }
    }

    public T unequip(){
        if (this.has()){
            T pointer = this.item;
            this.item = null;
            this.resetBonus();
            this.setChanged();  		// notify Observers
            this.notifyObservers();
            return pointer;
        }
        else{
            return item;
        }
    }
    
    public T get(){
        return this.item;
    }
    
    public <K extends T> boolean equip(K item){
        if (this.has()){
            return false;
        }
        else{
            this.item = item;
            this.setBonus();
            this.setChanged();  		//notify the Observers of change
            this.notifyObservers();
            return true;
        }
    }
}
