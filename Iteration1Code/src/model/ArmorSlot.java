package model;

public class ArmorSlot extends BufferSlot<Armor> implements Slotable<Armor> {
    ArmorSlot(ArmorRating stat){
    	this.addObserver(stat);
    }
    ArmorSlot(){}
    
    public int getBonus(){
    	return this.item.getBonus();
    }

    public static void main(String[] args){
        ArmorSlot slot = new ArmorSlot();
    	ArmorRating stat = new ArmorRating(0,slot);
    	slot.addObserver(stat);
        Armor armor = new Armor(15);
        //slot.equip(item);
        slot.equip(armor);
        System.out.println(stat);
    }
}
