package model.items.equipment;

import model.items.Armor;
import model.items.Boots;
import model.items.Gloves;
import model.items.Helmet;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.Weapons;
import model.occupation.*;
import model.slots.AlchemistWeaponSlot;
import model.slots.Equipment;
import model.slots.HunterWeaponSlot;
import model.slots.TerminatorWeaponSlot;

public class EquipmentBuilder {
	private int beginValue = 1;
	/*
	 * The idea is to build sets that NPCs will use and have a method that is specific to the 
	 * Occupation of the NPC and request that build
	 * 
	 */
	
	/*******************BEGINER EQUIPMENT******************************/
	public Equipment buildBeginerEquipment(Terminator occupation){
		Equipment equipment = new Equipment(new TerminatorWeaponSlot());
		return setBeginEquipment(equipment);
	}
	
	public Equipment buildBeginerEquipment(Hunter occupation){
		Equipment equipment = new Equipment(new HunterWeaponSlot());
		return setBeginEquipment(equipment);
	}
	
	public Equipment buildBeginerEquipment(Alchemist occupation){
		Equipment equipment = new Equipment(new AlchemistWeaponSlot());
		return setBeginEquipment(equipment);
	}
	
	public Equipment setBeginEquipment(Equipment equipment){
		equipment.equip( new Armor(beginValue));
    	equipment.equip( new Boots(beginValue));
    	equipment.equip(new Shield(beginValue));
    	equipment.equip( new Gloves(beginValue));
    	equipment.equip(new Leggings(beginValue));
    	equipment.equip( new Helmet(beginValue));
    	equipment.equip(new Projectile(beginValue));
    	setBeginWeaponSlot(equipment);
    	return equipment;
	}
	
	private void setBeginWeaponSlot(Equipment equipment){
		equipment.equip(Weapons.SWORD.weapon);
		equipment.equip(Weapons.LONGBOW.weapon);
		equipment.equip(Weapons.PHILOSOPHERS_STONE.weapon);
	}

	/*******************EMPTY*********************************/
	public Equipment emptyEquipment(Terminator terminator) {
		return new Equipment(new TerminatorWeaponSlot());
	}
	
	public Equipment emptyEquipment(Alchemist alchemist) {
		return new Equipment(new AlchemistWeaponSlot());
	}
	
	public Equipment emptyEquipment(Hunter hunter) {
		return new Equipment(new HunterWeaponSlot());
	}
	
	/***********************NPC TERMINATOR ***************************/
	public Equipment buildEquipmentTerminatorNPC(Terminator npc){
		return emptyEquipment(npc);
	}
	public Equipment buildEquipmentAlchemistNPC(Alchemist npc){
		return emptyEquipment(npc);
	}
	public Equipment buildEquipmentHunterNPC(Hunter npc){
		return emptyEquipment(npc);
	}
	
}
