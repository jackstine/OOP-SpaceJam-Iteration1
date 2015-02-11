package model;

public class InventorySlot implements Slotable<Item>{
    private Item item;

	//CONSTRUCTORS
	public InventorySlot(){}

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

    public <K extends Item> boolean equip(K item){
        if (this.has()) {
            return false;
        }
        else{
            this.item = item;
            return true;
        }
    }

    public Item unequip(){
        Item pointer = this.item;
        this.item = null;
        return pointer;
    }
    public Item get(){
        return this.item;
    }


}

