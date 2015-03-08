package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;


public class Helmet extends Equipable{
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

	public int getBonus() {
		return this.armor;
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}
}
