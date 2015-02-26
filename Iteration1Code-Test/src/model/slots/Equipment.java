package model.slots;

import java.util.Observable;
import java.util.Observer;

import model.ArmorRating;
import model.DerivedStat;
import model.OffensiveRating;
import model.Point;
import model.items.Equipable;
import model.items.TakeableItem;
import utilities.Scaling;
import view.EquipmentView;

public class Equipment implements Observer{
    public static final Point ARMOR_SLOT = EquipmentView.ARMOR_POINT;
	public static final Point WEAPON_SLOT = EquipmentView.WEAPON_POINT;
	public static final Point HELMET_SLOT = EquipmentView.HELMET_POINT;
	public static final Point GLOVES_SLOT = EquipmentView.GLOVES_POINT;
	public static final Point BOOTS_SLOT = EquipmentView.BOOTS_POINT;
	public static final Point SHIELD_SLOT = EquipmentView.SHIELD_POINT;
	public static final Point LEGGINGS_SLOT = EquipmentView.LEGGINGS_POINT;
	public static final Point QUIVER_SLOT = EquipmentView.QUIVER_POINT;
	
	private final BufferSlot[][] slots = new BufferSlot[Scaling.EQUIPMENT_SLOTS_WIDTH_NUM][Scaling.EQUIPMENT_SLOTS_HEIGHT_NUM];
    
    private BufferSlot armorSlot;
    private BufferSlot weaponSlot;
    private BufferSlot helmetSlot;
    private BufferSlot bootsSlot;
    private BufferSlot leggingsSlot;
    private BufferSlot shieldSlot;
    private BufferSlot glovesSlot;
    private BufferSlot quiverSlot;
    
    private EquipmentView equipmentView;
	
	
    //Since this class extends the SlotContainer, it can 
    
    //TODO delete this constructor  JUST FOR TESTING PURPOSES
    public Equipment(){
    	this.armorSlot = new ArmorSlot(this);
    	this.weaponSlot = new WeaponSlot(this);
    	this.helmetSlot = new HelmetSlot(this);
    	this.glovesSlot = new GlovesSlot(this);
    	this.leggingsSlot = new LeggingsSlot(this);
    	this.shieldSlot = new ShieldSlot(this);
    	this.bootsSlot = new BootsSlot(this);
    	this.quiverSlot = new QuiverSlot(this);
    	setArrayPoints();
    }
    
    public Equipment(DerivedStat armorRating, DerivedStat offensiveRating){
        this.armorSlot = new ArmorSlot(armorRating);
        ((ArmorRating)armorRating).setSlotSubject((ArmorSlot)this.armorSlot);
        this.weaponSlot = new WeaponSlot(offensiveRating);
        ((OffensiveRating)offensiveRating).setSlotSubject((WeaponSlot)this.weaponSlot);
        setArrayPoints();
    }
    
    private void setArrayPoints(){
    	this.setSlot(ARMOR_SLOT, this.armorSlot);
    	this.setSlot(WEAPON_SLOT,this.weaponSlot);
    	this.setSlot(BOOTS_SLOT, this.bootsSlot);
    	this.setSlot(SHIELD_SLOT, this.shieldSlot);
    	this.setSlot(GLOVES_SLOT, this.glovesSlot);
    	this.setSlot(HELMET_SLOT, this.helmetSlot);
    	this.setSlot(LEGGINGS_SLOT, this.leggingsSlot);
    	this.setSlot(QUIVER_SLOT, this.quiverSlot);
    }
    
    private void setSlot(Point point, BufferSlot slot){
    	this.slots[point.getY()][point.getX()] = slot;
    }
    
    public BufferSlot getSlot(Point point){
    	return this.slots[point.getY()][point.getX()];
    }
	
	private void notifyView(){
		if (this.equipmentView == null){
			return;
		}else{
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
