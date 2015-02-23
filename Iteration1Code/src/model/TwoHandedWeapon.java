package model;

public class TwoHandedWeapon extends Equipable{
	private int attack;
	//private Point slot = EquipmentView.TWO_HANDED_WEAPON_POINT;

	public TwoHandedWeapon(int attack){
		this.attack = attack;
	}
	
	public void accept(ItemVisitor visitor) {
		visitor.accept(this);
	}

	@Override
	public String getItemName() {
		return null;
	}

	public TakeableItem equipSlot(Equipment equipment) {
		return null;
	}

	public int getBonus() {
		return this.attack;
	}

	public boolean equip(ArmorSlot slot) {
		return false;
	}
	public boolean equip(WeaponSlot slot) {
		return false;
	}
	public boolean equip(HelmetSlot slot){
		return false;
	}
	public boolean equip(BootsSlot slot){
		return false;
	}
	public boolean equip(ShieldSlot slot){
		return false;
	}
	public boolean equip(LeggingsSlot slot){
		return false;
	}
	public boolean equip(GlovesSlot slot){
		return false;
	}
	public boolean equip(QuiverSlot slot){
		return false;
	}
}
