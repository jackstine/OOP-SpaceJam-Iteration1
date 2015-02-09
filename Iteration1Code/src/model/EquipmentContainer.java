package model;

public class EquipmentContainer extends SlotContainer{
	
	private ArmorSlot armor;
	private WeaponSlot weapon;
	

	public boolean equipArmor(Weapon weapon, Slot from) {

		return true;
	}
	
	public boolean equipWeapon(Weapon weapon, Slot from) {

		return true;
	}
	
	public boolean unequipArmor() {
		
		return true;
	}
	
	public boolean unequipWeapon() {

		return true;
	}
	
	
	@Override
	protected boolean equip(Slot to, Slot from, Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Item unequip(Slot slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean drop(Slot slot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean swap(Slot slot1, Slot slot2) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
