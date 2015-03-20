package model.occupation;

import model.EquipmentBuilder;
import model.SkillFactory;
import model.StatFactory;
import model.entity.Entity;
import model.slots.Equipment;
import model.slots.WeaponSlot;
import utilities.SpriteSheetUtility;

public class Orc extends Occupation{

	public Equipment createEquipment(EquipmentBuilder eb) {
		return null;
	}

	public Equipment createEmptyEquipment(EquipmentBuilder eb) {
		return null;
	}

	public WeaponSlot makeWeaponSlot() {
		return null;
	}

	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	
	public void attack(Entity entity) {
	}

	
	protected StatFactory getStatFactory(Equipment equipment) {
		return null;
	}

	
	protected SkillFactory getSkillFactory() {
		return null;
	}

}
