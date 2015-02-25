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
	
	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}
	
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}

}
