package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public class Gloves extends Equipable{
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

	public int getBonus() {
		return this.armor;
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
	
	public String toString() {
		return "Gloves:" + this.getBonus();
	}
}
