package model;

import java.io.Serializable;

import view.EquipmentView;

public class Equipment extends SlotContainer implements Serializable{
    private Slotable<Armor> armorSlot;
    private Slotable<Weapon> weaponSlot;
    private EquipmentView equipmentView;

    //Since this class extends the SlotContainer, it can 
    
    //TODO delete this constructor  JUST FOR TESTING PURPOSES
    public Equipment(){
    	this.armorSlot = new ArmorSlot();
    	this.weaponSlot = new WeaponSlot();
    }
    
    public Equipment(DerivedStat armorRating, DerivedStat offensiveRating){
        this.armorSlot = new ArmorSlot(armorRating);
        ((ArmorRating)armorRating).setSlotSubject((ArmorSlot)this.armorSlot);
        this.weaponSlot = new WeaponSlot(offensiveRating);
        ((OffensiveRating)offensiveRating).setSlotSubject((WeaponSlot)this.weaponSlot);
    }

	public <K extends Armor> boolean equipArmor(K armor){
        boolean returnValue = this.equip(this.armorSlot,armor);
        return returnValue;
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

	public Slotable<Armor> getArmorSlot(){
		return this.armorSlot;
	}
	
	public Slotable<Weapon> getWeaponSlot(){
		return this.weaponSlot;
	}
	
	protected void primitive(){
		if (this.equipmentView == null){
			return;
		}
		else{
			System.out.println("hello hitting");
			this.notifyView();
		}
	}
	
	private void notifyView(){
		this.equipmentView.update();
	}
	
    protected <K extends Item> Slotable<K> getSlot(Point point){
       throw new IllegalArgumentException("Cant Associate a BufferSlot in Equipment with a Point");
    }
    
    public void addObserver(EquipmentView equipmentView){
    	this.equipmentView = equipmentView;
    }
    
    public String toString() {
    	 return this.armorSlot + "\n" + this.weaponSlot;
    }
}
