package model;

import model.items.Armor;
import model.items.Boots;
import model.items.Gloves;
import model.items.Helmet;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.Weapons;
import model.occupation.Occupation;
import model.slots.Equipment;

public class EquipmentBuilder {
	private int beginValue = 1;
	
	public Equipment buildBeginerEquipment(Occupation occupation){
		Equipment equipment = new Equipment(occupation.makeWeaponSlot());
		equipment.equipSlot(Equipment.ARMOR_SLOT, new Armor(beginValue));
    	equipment.equipSlot(Equipment.BOOTS_SLOT, new Boots(beginValue));
    	equipment.equipSlot(Equipment.SHIELD_SLOT, new Shield(beginValue));
    	equipment.equipSlot(Equipment.GLOVES_SLOT, new Gloves(beginValue));
    	equipment.equipSlot(Equipment.LEGGINGS_SLOT, new Leggings(beginValue));
    	equipment.equipSlot(Equipment.HELMET_SLOT, new Helmet(beginValue));
    	equipment.equipSlot(Equipment.QUIVER_SLOT, new Projectile(beginValue));
    	setBeginWeaponSlot(equipment);
    	return equipment;
	}
	
	private void setBeginWeaponSlot(Equipment equipment){
		equipment.equipSlot(Equipment.WEAPON_SLOT,Weapons.SWORD.weapon);
		equipment.equipSlot(Equipment.WEAPON_SLOT,Weapons.LONGBOW.weapon);
		equipment.equipSlot(Equipment.WEAPON_SLOT, Weapons.PHILOSOPHERS_STONE.weapon);
	}
	
}
