package model.slots;

import java.util.Observable;

import model.items.TakeableItem;
import view.SlotView;

public class InventorySlot extends Observable {
    private TakeableItem item;

	//CONSTRUCTORS
	public InventorySlot(){}
	
	public InventorySlot(SlotView view){
		this.addObserver(view);
	}

	InventorySlot(TakeableItem item){
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

    public boolean equip(TakeableItem item){
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

    public TakeableItem unequip(){
        TakeableItem pointer = this.item;
        this.item = null;
        this.setChanged();
        this.notifyObservers();			//notify the Observers,  the Views
        return pointer;
    }
    public TakeableItem get(){
        return this.item;
    }


}

