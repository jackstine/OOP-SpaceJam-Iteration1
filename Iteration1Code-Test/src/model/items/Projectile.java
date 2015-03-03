package model.items;

import model.Avatar;
import model.slots.Equipment;


public class Projectile extends Equipable{
	private int attack;
	
	public Projectile(int attack){
		this.attack = attack;
	}
	
	public boolean action(Avatar avatar){
		return avatar.equip(this);
	}
	
	public boolean equipItem(Equipment equipment){
		return equipment.equip(this);
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
