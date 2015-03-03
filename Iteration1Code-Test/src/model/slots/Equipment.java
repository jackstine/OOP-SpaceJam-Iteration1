package model.slots;

import java.util.Observable;
import java.util.Observer;

import model.ArmorRating;
import model.OffensiveRating;
import model.Point;
import model.items.Armor;
import model.items.Boots;
import model.items.Equipable;
import model.items.Gloves;
import model.items.Helmet;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.TakeableItem;
import model.items.TerminatorTwoHandedWeapon;
import model.items.Weapon;
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
    
    private ArmorSlot armorSlot;
    private WeaponSlot weaponSlot;
    private HelmetSlot helmetSlot;
    private BootsSlot bootsSlot;
    private LeggingsSlot leggingsSlot;
    private ShieldSlot shieldSlot;
    private GlovesSlot glovesSlot;
    private QuiverSlot quiverSlot;
    private TwoHandedWeaponSlot THWSlot;
    
    private EquipmentView equipmentView;
	
    //Since this class extends the SlotContainer, it can 
    
    //TODO delete this constructor  JUST FOR TESTING PURPOSES
    //TODO we will need to form the two WeaponSlots together
    public Equipment(TerminatorWeaponSlot weaponSlot){
    	this.createEquipment(weaponSlot);
    	this.THWSlot = new TwoHandedWeaponSlot(weaponSlot,this.shieldSlot);
    }
    
    public Equipment(HunterWeaponSlot weaponSlot){
    	createEquipment(weaponSlot);
    }
    
    public Equipment(AlchemistWeaponSlot weaponSlot){
    	createEquipment(weaponSlot);
    }
    
    private void createEquipment(WeaponSlot weaponSlot){
    	this.armorSlot = new ArmorSlot(this);
    	this.weaponSlot = weaponSlot;
    	this.weaponSlot.addObserver(this);
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
    
	public Equipable unequipHelmet(){return helmetSlot.unequip();}
	public Equipable unequipArmor(){return armorSlot.unequip();}
	public Equipable unequipWeapon(){return weaponSlot.unequip();}
	public Equipable unequipLeggings(){return leggingsSlot.unequip();}
	public Equipable unequipBoots(){return bootsSlot.unequip();}
	public Equipable unequipGloves(){return glovesSlot.unequip();}
	public Equipable unequipProjectile(){return quiverSlot.unequip();}
	public Equipable unequipShield(){
		if (THWSlot != null)
			return this.unequipShieldTHW();
		else
			return shieldSlot.unequip();
	}
	public Equipable unequipTHW(){
		if (THWSlot != null)return THWSlot.unequip();
		else return null;
	}
	public Equipable unequipWeaponTHW(){
		if (THWSlot != null)
			return this.THWSlot.unequipWeapon();
		else return null;
	}
	public Equipable unequipShieldTHW(){
		if (THWSlot != null)
			if (THWSlot.has())
				return this.THWSlot.unequip();
			else
				return this.THWSlot.unequipShield();
		else return null;
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
	
	public Equipable unequipSlot(Point point){
		Equipable item = this.slots[point.getY()][point.getX()].unequip();
		this.notifyView();
		return item;
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
	
	public boolean equip(TerminatorTwoHandedWeapon thw){
		if (this.THWSlot != null)
			return this.THWSlot.equip(thw);
		else return false;
	}
	
	public boolean equip(Helmet helmet){return this.helmetSlot.equip(helmet);}
	public boolean equip(Weapon weapon){return this.weaponSlot.equip(weapon);}
	public boolean equip(Armor armor){return this.armorSlot.equip(armor);}
	public boolean equip(Leggings leggings){return this.leggingsSlot.equip(leggings);}
	public boolean equip(Boots boots){return this.bootsSlot.equip(boots);}
	public boolean equip(Gloves gloves){return this.glovesSlot.equip(gloves);}
	public boolean equip(Projectile projectile){return this.quiverSlot.equip(projectile);}
	public boolean equip(Shield shield){return this.shieldSlot.equip(shield);}

	public boolean equipItem(Equipable item) {
		return item.equipItem(this);
	}
}
