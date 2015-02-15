package model;

public class Weapon extends Equipable {
	private int attack;
	
	public Weapon(int attack) {
		this.attack = attack;
		this.ITEM_IMAGE = "src/res/img/weapon.png";
	}
	
	public Weapon(int attack, String image) {
		this.attack = attack;
		this.ITEM_IMAGE = image;
	}
	
	public boolean action(Avatar avatar) {
		//TODO  fill in
		return true;
	}
	
	public int getBonus() {
		return this.attack;
	}
	public String toString(){
		return "Item:Weapon:" + this.attack;
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

	@Override
	public boolean equip(ArmorSlot slot) {
		return false;
	}

	@Override
	public boolean equip(WeaponSlot slot) {
		return slot.equip(this);
	}
}
