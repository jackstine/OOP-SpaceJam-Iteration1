package model;

public class Equipment extends SlotContainer{
    private Slotable<Armor> armorSlot;
    private Slotable<Weapon> weaponSlot;

    //Since this class extends the SlotContainer, it can 
    //al
    
    Equipment(ArmorRating defense,OffensiveRating offense){
        this.armorSlot = new ArmorSlot(defense);
        this.weaponSlot = new WeaponSlot(offense);
    }

	public <K extends Armor> boolean equipArmor(K armor){
        return this.equip(this.armorSlot,armor);
    }
//    public boolean equipArmor(Armor armor,Point from){
//        return this.equip(this.armorSlot, from);
//    }
    public <K extends Weapon> boolean equipWeapon(K weapon){
        return this.equip(this.weaponSlot ,weapon);
    }
//    public boolean equipWeapon(Weapon weapon,Point from){
//        return this.equip(this.weaponSlot ,from);
//    }
    protected <K extends Item> Slotable<K> getSlot(Point point){
       throw new IllegalArgumentException("Cant Associate a BufferSlot in Equipment with a Point");
    }
    public static void main(String[] args){
    	
    }
}
