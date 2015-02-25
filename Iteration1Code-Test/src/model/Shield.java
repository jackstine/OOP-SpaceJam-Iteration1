package model;

import view.EquipmentView;

public class Shield extends Equipable{
	protected final static Point SLOT = EquipmentView.SHIELD_POINT;
	
	private int armor;

	public Shield(int armor){
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
}
