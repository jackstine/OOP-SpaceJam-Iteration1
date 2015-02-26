package model.items;

import model.Point;
import model.slots.Equipment;
import view.EquipmentView;

public class Helmet extends Equipable{
	private final static Point SLOT = EquipmentView.HELMET_POINT;
	private int armor;

	public Helmet(int armor){
		this.armor = armor;
	}
	
	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}

	public String getItemName() {
		// TODO Auto-generated method stub
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
