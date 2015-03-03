package model.items;

import model.Avatar;
import model.slots.Equipment;

public class Shield extends Equipable{
	
	private int armor;

	public Shield(int armor){
		this.armor = armor;
	}
	
	public boolean action(Avatar avatar){
		return avatar.equip(this);
	}
	
	public boolean equipItem(Equipment equipment){
		return equipment.equip(this);
	}
	
	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}

	public String getItemName() {
		return null;
	}

	public int getBonus() {
		return this.armor;
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
}
