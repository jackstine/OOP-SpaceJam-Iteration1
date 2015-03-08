package model.items;

import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;


public class Projectile extends Equipable{
	private int attack;
	
	public Projectile(int attack){
		this.attack = attack;
	}
	
	public int getBonus() {
		return this.attack;
	}
	
	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}
	
	public String getItemName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void accept(EquipableVisitor visitor){
		visitor.accept(this);
	}

}
