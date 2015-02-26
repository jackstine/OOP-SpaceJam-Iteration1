package model.items;

import model.Point;
import model.slots.ArmorSlot;
import model.slots.BootsSlot;
import model.slots.Equipment;
import model.slots.GlovesSlot;
import model.slots.HelmetSlot;
import model.slots.LeggingsSlot;
import model.slots.QuiverSlot;
import model.slots.ShieldSlot;
import model.slots.WeaponSlot;
import view.EquipmentView;

public class Gloves extends Equipable{
	private final static Point SLOT = EquipmentView.GLOVES_POINT;
	private int armor;

	public Gloves(int armor){
		this.armor = armor;
	}
	
	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}

	public String getItemName() {
		return null;
	}

	public TakeableItem equipSlot(Equipment equipment) {
		TakeableItem item = equipment.unequipSlot(SLOT);
		equipment.equipSlot(SLOT,this);
		return item;
	}

	public int getBonus() {
		return this.armor;
	}
	
	public boolean equip(ArmorSlot slot) {
		return false;
	}
	public boolean equip(WeaponSlot slot) {
		return false;
	}
	public boolean equip(HelmetSlot slot){
		return false;
	}
	public boolean equip(BootsSlot slot){
		return false;
	}
	public boolean equip(ShieldSlot slot){
		return false;
	}
	public boolean equip(LeggingsSlot slot){
		return false;
	}
	public boolean equip(GlovesSlot slot){
		return slot.equip(this);
	}
	public boolean equip(QuiverSlot slot){
		return false;
	}
}
