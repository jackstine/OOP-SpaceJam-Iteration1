package model;

import java.util.Observable;

import view.SlotView;

public class InventorySlot extends Observable {
    private Item item;

	//CONSTRUCTORS
	public InventorySlot(){}
	
	public InventorySlot(SlotView view){
		this.addObserver(view);
	}

	InventorySlot(Item item){
        this.item = item;
	}

	//METHODS
	public boolean has(){
        //NOTE null pointer, dont know if we want to have null pointers floating around
        if (this.item == null){
            return false;
        }
        else{
            return true;
        }
	}

    public boolean equip(Item item){
        if (this.has()) {
            return false;
        }
        else{
            this.item = item;
            this.setChanged();
            this.notifyObservers();		//notify the Observers, the Views
            return true;
        }
    }

    public Item unequip(){
        Item pointer = this.item;
        this.item = null;
        this.setChanged();
        this.notifyObservers();			//notify the Observers,  the Views
        return pointer;
    }
    public Item get(){
        return this.item;
    }


}

