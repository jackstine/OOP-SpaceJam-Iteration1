package model;

import java.util.Observable;

public abstract class BufferSlot<T extends Item> extends Observable implements Slotable<T>{
	//TOD this should not implement, or at least the implementation should be in another abstract/class
	
	
	
    protected T item;
    BufferSlot(){}  //should never be called except for testing purposes

    //TODO need to notify the observers of this class
// TODO add this constructor when added the stats
//    BufferSlot(Primary stat){
//        this.addObserver(stat);
//    }

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
            this.setChanged();  		// notify Observers
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
            this.setChanged();  		//notify the Observers of change
            return true;
        }
    }
}
