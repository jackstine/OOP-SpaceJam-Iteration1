package model;

public abstract class SlotContainer{
    
    //Template Methods
    public final <K extends Item> K get(Slotable<K> slot){
        return slot.get();
    }
//    public final Item get(BufferSlot slot){
//        return slot.get();
//    }
//    public final boolean equip(Point to,Point from){    //Template Method
//        return this.equipItem(this.getSlot(to),this.getSlot(from));
//    }
//    public final boolean equip(BufferSlot to, Point from){
//        return this.equipItem(to,this.getSlot(from));
//    }
    public final <K extends Item> boolean equip(Point point,K item){  //Template Method
        return this.equipItem(this.getSlot(point),item);
    }
//    public final boolean equip(BufferSlot buffer,Slotable<Item> itemSlot){
//        return this.equipItem(buffer,itemSlot);
//    }
    public final <K extends Item> boolean equip(Slotable<K> to,Slotable<K> from){
        return this.equipItem(to,from);
    }
    public final <K extends Item> boolean equip(Slotable<K> to, K item){
    	return this.equipItem(to, item);
    }
    // equip(BufferSlot, Item) should never happen
//    public final boolean swap(Point to,Point from){     //Template Method
//        return this.swapItem(this.getSlot(to),this.getSlot(from));
//    }
//    public final boolean swap(Point to,Slotable<Item> from){//Template Method
//        return this.swapItem(this.getSlot(to),from);
//    }
//    public final boolean swap(BufferSlot to,Slotable<Item>from){
//        return this.swapItem(to,from);
//    }
//    public final boolean swap(Slotable<Item> to,BufferSlot from){
//        return this.swapItem(from,to);
//    }
//    public final Item unequip(Point slot){              //Template Method
//        return this.unequipItem(this.getSlot(slot));
//    }
//    public final Item unequip(BufferSlot slot){
//        return this.unequipItem(slot);
//    }
//    public final boolean drop(Point slot){              //Template Method
//        return this.dropItem(this.getSlot(slot));
//    }

//    public final boolean drop(BufferSlot slot){
//        return this.dropItem(slot);
//    }

    // final Methods to keep encapsulation in the Abstract Class
    //these classes are used for both Slot<Item> and BufferSlot
    //IMPLEMENTED
//    protected final boolean dropItem(Slotable<Item> slot){
//        //the item is unequiped and dropped forever
//        if (slot.has()){
//            slot.unequip();
//            return true;
//        }
//        return false;
//    }
//    protected final boolean dropItem(BufferSlot slot){
//        if (slot.has()){
//            slot.unequip();
//            return true;
//        }
//        return false;
//    }
//    protected final Item unequipItem(Slotable<Item> slot){
//        return slot.unequip();
//    }
//    protected final Item unequipItem(BufferSlot slot){
//        return slot.unequip();
//    }
    protected final <K extends Item> boolean equipItem(Slotable<K> slot,K item){ 
       return slot.equip(item);
    }
    protected final <K extends Item> boolean equipItem(Slotable<K> to,Slotable<K> from){
//        if (to.has()){
//            return this.swapItem(to,from);
//        }
//        else{
            return to.equip(from.unequip());
//        }
    }
//    protected final boolean equipItem(BufferSlot to,Slotable<Item> from){
//        return this.equipItem(from,to);
//    }
//    protected final boolean equipItem(Slotable<Item> to,BufferSlot from){
//        Slot<Item> temp = from.convert();
//        if (this.equipItem(to,temp)){
//            return true;
//        }
//        else{
//            return from.equipItem(temp.unequip());
//        }
//    }
    //Swaps between the same type
//    protected final <K extends Item> boolean swapItem(Slotable<K> to,Slotable<K> from){
//        K temp = (K)from.unequip();
//        from.equip(to.unequip());
//        return to.equip(temp);
//    }
//    protected final boolean swapItem(BufferSlot to, Slotable<Item> from){
//        return this.swapItem(from,to);
//    }
//    protected final boolean swapItem(Slotable<Item> to, BufferSlot from){
//        Slot<Item> temp = from.convert();
//        this.swapItem(to,temp);
//        return from.equipItem(temp.unequip());
//    }

    //PRIMITIVE METHODS
    protected abstract <K extends Item> Slotable<K> getSlot(Point slot);
    
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
