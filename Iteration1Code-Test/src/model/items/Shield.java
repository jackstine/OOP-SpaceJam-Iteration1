package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public class Shield extends Equipable{
	
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

	public int getBonus() {
		return this.armor;
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
}
