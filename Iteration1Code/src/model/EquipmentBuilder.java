package model;

public class EquipmentBuilder {
	private int beginValue = 1;
	
	public void buildBeginningEquipment(Equipment equipment){
		equipment.equipSlot(Equipment.ARMOR_SLOT, new Armor(beginValue));
    	equipment.equipSlot(Equipment.WEAPON_SLOT,new Weapon(beginValue));
    	equipment.equipSlot(Equipment.BOOTS_SLOT, new Boots(beginValue));
    	equipment.equipSlot(Equipment.SHIELD_SLOT, new Shield(beginValue));
    	equipment.equipSlot(Equipment.GLOVES_SLOT, new Gloves(beginValue));
    	equipment.equipSlot(Equipment.LEGGINGS_SLOT, new Leggings(beginValue));
    	equipment.equipSlot(Equipment.HELMET_SLOT, new Helmet(beginValue));
    	equipment.equipSlot(Equipment.QUIVER_SLOT, new Projectile(beginValue));
	}

}
