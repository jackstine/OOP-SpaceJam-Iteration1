package model;

public abstract class SlotContainer{
	//We want to be able to take any type of Slotable item and
	//As well take a Point,  which is used in the InventoryContainer
	
    //TEMPLATE METHODS
    public final Item get(InventorySlot slot){
        return slot.get();
    }
    public final boolean equip(Point to,Point from){    
        return this.equipItem(this.getSlot(to),this.getSlot(from));
    }
    public final boolean equip(InventorySlot to, Point from){
        return this.equipItem(to,this.getSlot(from));
    }
    public final <K extends Item> boolean equip(Point point,K item){  
        return this.equipItem(this.getSlot(point),item);
    }
    public final <K extends Item> boolean equip(InventorySlot to,InventorySlot from){
        return this.equipItem(to,from);
    }
    public final <K extends Item> boolean equip(InventorySlot to, K item){
    	return this.equipItem(to, item);
    }
    public final boolean swap(Point to,Point from){     
        return this.swapItem(this.getSlot(to),this.getSlot(from));
    }
    public final boolean swap(Point to,InventorySlot from){
        return this.swapItem(this.getSlot(to),from);
    }
    public final boolean swap(InventorySlot to, InventorySlot from){
        return this.swapItem(to,from);
    }
    public final Item unequip(Point slot){              
        return this.unequipItem(this.getSlot(slot));
    }
    public final Item unequip(InventorySlot slot){
        return this.unequipItem(slot);
    }
    public final boolean drop(Point slot){              
        return this.dropItem(this.getSlot(slot));
    }
    public final <K extends Item> boolean drop(InventorySlot slot){
        return this.dropItem(slot);
    }

    //IMPLEMENTED
    protected final <K extends Item> boolean dropItem(InventorySlot slot){
        //the item is unequiped and dropped forever
        if (slot.has()){
            slot.unequip();	//gets dropped here
            primitive();
            return true;
        }
        return false;
    }
    protected final Item unequipItem(InventorySlot slot){
        Item returnValue = slot.unequip();
        primitive();
        return returnValue;
    }
    protected final <K extends Item> boolean equipItem(InventorySlot slot,K item){ 
       boolean returnValue = slot.equip(item);
       primitive();
       return returnValue;
    }
    protected final boolean equipItem(InventorySlot to,InventorySlot from){
        if (to.has()){
            return this.swapItem(to,from);
        }
        else{
            boolean returnValue = to.equip(from.unequip());
            primitive();
            return returnValue;
        }
    }
     
    protected final boolean swapItem(InventorySlot to,InventorySlot from){
        Item temp = from.unequip();
        from.equip(to.unequip());
        boolean returnValue = to.equip(temp);
        primitive();
        return returnValue;
    }

    //PRIMITIVE METHODS
    protected abstract InventorySlot getSlot(Point slot);
    
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
