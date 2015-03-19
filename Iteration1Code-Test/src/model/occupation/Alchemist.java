package model.occupation;

import utilities.SpriteSheetUtility;
import model.*;
import model.entity.Entity;
import model.slots.*;

public class Alchemist extends Occupation{
	
	public Alchemist() {
		this.portraitLocation = "src/res/img/alchemist_portrait.jpg";
		this.name = "Alchemist";
	}
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new AlchemistStatFactory(equipment);
	}
	
	public WeaponSlot makeWeaponSlot(){
		return new AlchemistWeaponSlot();
	}
	
	public Equipment createEquipment(EquipmentBuilder eb) {
		return eb.buildBeginerEquipment(this);
	}
	
	public Equipment createEmptyEquipment(EquipmentBuilder eb) {
		return eb.emptyEquipment(this);
	}
	
	public void attack(Entity entity) {
		// create "CombatSimulator" class that will carry
		// out the fighting between Avatar and Entity
	}
	
	public SpriteSheetUtility getSpriteSheet() {
		return new SpriteSheetUtility(this);
	}

	@Override
	protected SkillFactory getSkillFactory() {
		return new AlchemistSkillFactory();
	}
}
