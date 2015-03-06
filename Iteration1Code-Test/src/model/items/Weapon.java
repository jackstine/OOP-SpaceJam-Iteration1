package model.items;

import model.slots.AlchemistWeaponSlot;
import model.slots.HunterWeaponSlot;
import model.slots.TerminatorWeaponSlot;
import model.visitor.EquipableVisitor;
import model.visitor.ItemVisitor;

public abstract class Weapon extends Equipable {
	private int attack;
	
	public Weapon(int attack) {
		this.attack = attack;
		this.ITEM_NAME = "Weapon";
	}
	
	public Weapon(int attack, String image) {
		this.attack = attack;
		this.ITEM_NAME = "Weapon";
	}
	
	public abstract void accept(ItemVisitor visitor);
	
	public int getBonus() {
		return this.attack;
	}
	public String toString(){
		return "Item:Weapon:" + this.attack;
	}
	
	public boolean equip(TerminatorWeaponSlot slot){return false;}
	public boolean equip(HunterWeaponSlot slot){return false;}
	public boolean equip(AlchemistWeaponSlot slot){return false;}
	
	public String getItemName() {
		return this.ITEM_NAME;
	}
	
	public abstract void accept(EquipableVisitor visitor);
}
