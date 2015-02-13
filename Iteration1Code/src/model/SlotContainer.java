package model;

import java.io.Serializable;

public abstract class SlotContainer implements Serializable{
	//We want to be able to take any type of Slotable<K> item and
	//As well take a Point,  which is used in the InventoryContainer
	
    //TEMPLATE METHODS
    public final <K extends Item> K get(Slotable<K> slot){
        return slot.get();
    }
    public final boolean equip(Point to,Point from){    
        return this.equipItem(this.getSlot(to),this.getSlot(from));
    }
    public final <K extends Item> boolean equip(Slotable<K> to, Point from){
        return this.equipItem(to,this.getSlot(from));
    }
    public final <K extends Item> boolean equip(Point point,K item){  
        return this.equipItem(this.getSlot(point),item);
    }
    public final <K extends Item> boolean equip(Slotable<K> to,Slotable<K> from){
        return this.equipItem(to,from);
    }
    public final <K extends Item> boolean equip(Slotable<K> to, K item){
    	return this.equipItem(to, item);
    }
    public final boolean swap(Point to,Point from){     
        return this.swapItem(this.getSlot(to),this.getSlot(from));
    }
    public final boolean swap(Point to,Slotable<Item> from){
        return this.swapItem(this.getSlot(to),from);
    }
    public final <K extends Item> boolean swap(Slotable<K> to,Slotable<K>from){
        return this.swapItem(to,from);
    }
    public final Item unequip(Point slot){              
        return this.unequipItem(this.getSlot(slot));
    }
    public final <K extends Item> K unequip(Slotable<K> slot){
        return this.unequipItem(slot);
    }
    public final boolean drop(Point slot){              
        return this.dropItem(this.getSlot(slot));
    }
    public final <K extends Item> boolean drop(Slotable<K> slot){
        return this.dropItem(slot);
    }

    //IMPLEMENTED
    protected final <K extends Item> boolean dropItem(Slotable<K> slot){
        //the item is unequiped and dropped forever
        if (slot.has()){
            slot.unequip();	//gets dropped here
            primitive();
            return true;
        }
        return false;
    }
    protected final <K extends Item> K unequipItem(Slotable<K> slot){
        K returnValue = slot.unequip();
        primitive();
        return returnValue;
    }
    protected final <K extends Item> boolean equipItem(Slotable<K> slot,K item){ 
       boolean returnValue = slot.equip(item);
       primitive();
       return returnValue;
    }
    protected final <K extends Item> boolean equipItem(Slotable<K> to,Slotable<K> from){
    	//TODO the commented outline has to work
    	
//        if (to.has()){
//            return this.swapItem(to,from);
//        }
//        else{
            boolean returnValue = to.equip(from.unequip());
            primitive();
            return returnValue;
//        }
    }
    
    //Swaps between the same type only
    //TODO Swap if the Item in a Item container is actual type Armor... 
    protected final <K extends Item> boolean swapItem(Slotable<K> to,Slotable<K> from){
        K temp = (K)from.unequip();
        from.equip(to.unequip());
        boolean returnValue = to.equip(temp);
        primitive();
        return returnValue;
    }

    //PRIMITIVE METHODS
    protected abstract <K extends Item> Slotable<K> getSlot(Point slot);
    
    protected abstract void primitive();
    
    static public void main(String[] args){
    	InventorySlot invSlot = new InventorySlot();
    	ArmorSlot armorSlot = new ArmorSlot();
    	Armor armor = new Armor();
    	Armor armor2 = new Armor();
    	invSlot.equip(armor);
    	armorSlot.equip(armor2);
    	Item temp = invSlot.unequip();
    	invSlot.equip(armorSlot.unequip());
    	armorSlot.equip((Armor)temp);
    }
}
