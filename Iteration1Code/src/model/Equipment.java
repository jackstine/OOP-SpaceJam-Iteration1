package model;

public class Equipment extends SlotContainer{
    private Slotable<Armor> armorSlot;
    private Slotable<Weapon> weaponSlot;

    //Since this class extends the SlotContainer, it can 
    //al
    
    Equipment(ArmorRating defense,OffensiveRating offense){
        this.armorSlot = new ArmorSlot(defense);
        defense.setSlotSubject((ArmorSlot)this.armorSlot);
        this.weaponSlot = new WeaponSlot(offense);
        offense.setSlotSubject((WeaponSlot)this.weaponSlot);
    }

	public <K extends Armor> boolean equipArmor(K armor){
        return this.equip(this.armorSlot,armor);
    }
	public Armor unequipArmor(){
		return this.unequip(this.armorSlot);
	}

    public <K extends Weapon> boolean equipWeapon(K weapon){
        return this.equip(this.weaponSlot ,weapon);
    }
	public Weapon unequipWeapon(){
		return this.unequip(this.weaponSlot);
	}

    protected <K extends Item> Slotable<K> getSlot(Point point){
       throw new IllegalArgumentException("Cant Associate a BufferSlot in Equipment with a Point");
    }
    public static void main(String[] args){
    	OffensiveRating off = new OffensiveRating();
    	ArmorRating def = new ArmorRating();
    	System.out.println(def+"    "+off);		// 0    0
    	Equipment equipment = new Equipment(def,off);
    	Armor armor = new Armor(15);
    	Weapon weapon = new Weapon(100);
    	equipment.equipArmor(armor);
    	System.out.println(def+"    "+off);	//  15    0
    	equipment.unequipArmor();
    	System.out.println(def+"    "+off); //  0     0
    	equipment.equipWeapon(weapon);
    	System.out.println(def+"    "+off);//  0      100
    	equipment.equipArmor(armor);
    	System.out.println(def+"    "+off);// 15      100
    	equipment.unequipWeapon();
    	System.out.println(def+"    "+off);// 15       0
    }
}
