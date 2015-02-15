package model;

import view.EquipmentView;

public class Weapon extends Equipable {
	private int attack;
	protected Point slot = EquipmentView.WEAPON_POINT;
	
	public Weapon(int attack) {
		this.attack = attack;
		this.ITEM_IMAGE = "src/res/img/weapon.png";
	}
	
	public Weapon(int attack, String image) {
		this.attack = attack;
		this.ITEM_IMAGE = image;
	}
	
	public int getBonus() {
		return this.attack;
	}
	public String toString(){
		return "Weapon:" + this.attack;
	}
	
	public static void main(String[] args){
		WeaponSlot weaponSlot = new WeaponSlot();
		InventorySlot invSlot = new InventorySlot();
		Weapon weapon = new Weapon(5);
		weaponSlot.equip(weapon);
		invSlot.equip(weaponSlot.unequip());
		//Type casting here to make it a Armor
		weaponSlot.equip((Weapon)invSlot.unequip());
		//weaponSlot.equip(invSlot.unequip());		This will not work
	}

	public boolean equip(ArmorSlot slot) {
		return false;
	}

	public boolean equip(WeaponSlot slot) {
		return slot.equip(this);
	}

	public TakeableItem equipSlot(Equipment equipment) {
		TakeableItem item = equipment.unequipSlot(this.slot);
		equipment.equipSlot(this.slot,this);
		return item;
	}
}
