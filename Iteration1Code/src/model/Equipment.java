package model;

import java.util.Observable;
import java.util.Observer;

import utilities.Scaling;
import view.EquipmentView;

public class Equipment implements Observer{
    private BufferSlot armorSlot;
    private BufferSlot weaponSlot;
    private EquipmentView equipmentView;
    public static final Point ARMOR_SLOT = EquipmentView.ARMOR_POINT;
	public static final Point WEAPON_SLOT = EquipmentView.WEAPON_POINT;
	
	//TODO map these
	public static final Point HELMET_SLOT = EquipmentView.HELMET_POINT;
	public static final Point GLOVES_SLOT = EquipmentView.GLOVES_POINT;
	public static final Point BOOTS_SLOT = EquipmentView.BOOTS_POINT;
	public static final Point SHIELD_SLOT = EquipmentView.SHIELD_POINT;
	public static final Point LEGGINGS_SLOT = EquipmentView.LEGGINGS_POINT;
	
	private final BufferSlot[][] slots = new BufferSlot[Scaling.EQUIPMENT_SLOTS_WIDTH_NUM][Scaling.EQUIPMENT_SLOTS_HEIGHT_NUM];
    

    //Since this class extends the SlotContainer, it can 
    
    //TODO delete this constructor  JUST FOR TESTING PURPOSES
    public Equipment(){
    	this.armorSlot = new ArmorSlot(this);
    	//System.out.println(this.armorSlot);
    	this.weaponSlot = new WeaponSlot(this);
    	//System.out.println(this.weaponSlot);
    	setArrayPoints();
    }
    
    private void setArrayPoints(){
    	this.setSlot(ARMOR_SLOT, this.armorSlot);
    	this.setSlot(WEAPON_SLOT,this.weaponSlot);
    }
    
    private void setSlot(Point point, BufferSlot slot){
    	//System.out.println(slot);
    	this.slots[point.getY()][point.getX()] = slot;
    }
    
    public BufferSlot getSlot(Point point){
    	return this.slots[point.getY()][point.getX()];
    }
    
    public Equipment(DerivedStat armorRating, DerivedStat offensiveRating){
        this.armorSlot = new ArmorSlot(armorRating);
        ((ArmorRating)armorRating).setSlotSubject((ArmorSlot)this.armorSlot);
        this.weaponSlot = new WeaponSlot(offensiveRating);
        ((OffensiveRating)offensiveRating).setSlotSubject((WeaponSlot)this.weaponSlot);
    }
	
	private void notifyView(){
		if (this.equipmentView == null){
			return;
		}
		else{
			this.equipmentView.update();
		}
	}
    
	public TakeableItem unequipSlot(Point point){
		TakeableItem item = this.getSlot(point).unequip();
    	this.notifyView();
    	return item;
    }
	
	public <K extends Equipable> boolean equipSlot(Point point, K item){
		boolean value = this.getSlot(point).equipItem(item);
		this.notifyView();
		return value;
	}
    
    public void addObserver(EquipmentView equipmentView){
    	this.equipmentView = equipmentView;
    }
    
    public String toString() {
    	 return this.armorSlot + "\n" + this.weaponSlot;
    }

	public TakeableItem getItemFromSlot(Point point) {
		return this.getSlot(point).get();
	}
	
	public void update(Observable arg0, Object arg1) {
		this.notifyView();
	}
}
