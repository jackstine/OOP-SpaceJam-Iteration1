package model;

public class Equipment extends SlotContainer{
    private Slotable<Armor> armorSlot;
    private Slotable<Weapon> weaponSlot;

    //Since this class extends the SlotContainer, it can 
    //al
    
    Equipment(){
        this.armorSlot = new ArmorSlot();
        this.weaponSlot = new WeaponSlot();
    }
    //TODO uncommit this code when we have the stats
//    Equipment(Map<String,Stat> stats){
//        this.armorSlot = new ArmorSlot(stats.get("ArmorStat"));
//        this.weaponSLot = new WeaponSlot(stats.get("AttackStat"));
//    }

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
