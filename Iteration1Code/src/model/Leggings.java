package model;

import view.EquipmentView;

public class Leggings extends Equipable{
	protected final static Point SLOT = EquipmentView.LEGGINGS_POINT;
	private int armor;
	
	public Leggings(int armor){
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
		return slot.equip(this);
	}
	public boolean equip(GlovesSlot slot){
		return false;
	}
	public boolean equip(QuiverSlot slot){
		return false;
	}
}
