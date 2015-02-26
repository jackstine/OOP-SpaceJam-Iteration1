package model.slots;

import model.items.Item;

public interface Slotable{
	
	public boolean has();
    public Item unequip();
    public Item get();
    public  boolean equip(Item item);
}
 