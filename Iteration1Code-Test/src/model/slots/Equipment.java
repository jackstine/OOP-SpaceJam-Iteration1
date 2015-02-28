package model.slots;

import java.util.Observable;
import java.util.Observer;

import model.ArmorRating;
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
    //TODO we will need to form the two WeaponSlots together
    public Equipment(WeaponSlot weaponSlot){
    	this.armorSlot = new ArmorSlot(this);
    	this.weaponSlot = weaponSlot;
    	this.helmetSlot = new HelmetSlot(this);
    	this.glovesSlot = new GlovesSlot(this);
    	this.leggingsSlot = new LeggingsSlot(this);
    	this.shieldSlot = new ShieldSlot(this);
    	this.bootsSlot = new BootsSlot(this);
    	this.quiverSlot = new QuiverSlot(this);
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
    
	public Equipable unequipSlot(Point point){
		Equipable item = this.getSlot(point).unequip();
    	this.notifyView();
    	return item;
    }
	
	public <K extends Equipable> boolean equipSlot(Point point, K item){
		boolean itemExist = item != null;
		if (itemExist){
			boolean value = this.getSlot(point).equipItem(item);
			this.notifyView();
			return value;
		}else return false;
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

	public BufferSlot[] getArmrorSlots() {
		BufferSlot[] slots = {this.getSlot(ARMOR_SLOT),
				this.getSlot(BOOTS_SLOT), this.getSlot(GLOVES_SLOT),
				this.getSlot(HELMET_SLOT), this.getSlot(LEGGINGS_SLOT),
				this.getSlot(SHIELD_SLOT)};
		return slots;
	}
	
	public void setDerivedStats(ArmorRating armor,OffensiveRating off){
	   	this.getSlot(ARMOR_SLOT).addObserver(armor);
    	this.getSlot(WEAPON_SLOT).addObserver(off);
    	this.getSlot(BOOTS_SLOT).addObserver(armor);
    	this.getSlot(SHIELD_SLOT).addObserver(armor);
    	this.getSlot(GLOVES_SLOT).addObserver(armor);
    	this.getSlot(HELMET_SLOT).addObserver(armor);
    	this.getSlot(LEGGINGS_SLOT).addObserver(armor);
    	this.getSlot(QUIVER_SLOT).addObserver(armor);
	}
}
