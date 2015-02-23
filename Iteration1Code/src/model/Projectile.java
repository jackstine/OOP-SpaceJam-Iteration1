package model;

import view.EquipmentView;

public class Projectile extends Equipable{
	private static final Point SLOT = EquipmentView.QUIVER_POINT;
	private int attack;
	
	public Projectile(int attack){
		this.attack = attack;
	}
	
	public int getBonus() {
		return this.attack;
	}
	
	public TakeableItem equipSlot(Equipment equipment) {
		TakeableItem item = equipment.unequipSlot(SLOT);
		equipment.equipSlot(SLOT,this);
		return item;
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
		return false;
	}
	public boolean equip(QuiverSlot slot){
		return false;
	}

	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}
	
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}

}
