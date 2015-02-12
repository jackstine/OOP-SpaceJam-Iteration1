package model;

public class Equipment extends SlotContainer{
    private Slotable<Armor> armorSlot;
    private Slotable<Weapon> weaponSlot;

    //Since this class extends the SlotContainer, it can 
    //al
    
    public Equipment(DerivedStat armorRating, DerivedStat offensiveRating){
        this.armorSlot = new ArmorSlot(armorRating);
        ((ArmorRating)armorRating).setSlotSubject((ArmorSlot)this.armorSlot);
        this.weaponSlot = new WeaponSlot(offensiveRating);
        ((OffensiveRating)offensiveRating).setSlotSubject((WeaponSlot)this.weaponSlot);
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
}
