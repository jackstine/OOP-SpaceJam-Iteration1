package model;

public class ArmorSlot extends BufferSlot<Armor> implements Slotable<Armor> {
    ArmorSlot(){}

    public static void main(String[] args){
        ArmorSlot slot = new ArmorSlot();
        Armor armor = new Armor();
        //slot.equip(item);
        slot.equip(armor);
    }
}
