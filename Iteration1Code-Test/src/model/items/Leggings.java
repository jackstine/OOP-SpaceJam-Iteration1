package model.items;

import model.Point;
import model.slots.Equipment;
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
}
