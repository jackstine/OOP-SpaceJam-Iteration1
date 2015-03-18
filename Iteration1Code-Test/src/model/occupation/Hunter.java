package model.occupation;


import utilities.SpriteSheetUtility;
import model.*;
import model.Entity.Entity;
import model.slots.*;

public class Hunter extends Occupation{

	public Hunter() {
		this.portraitLocation = "src/res/img/hunter_portrait.jpg";
		this.name = "Hunter";
	}
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new HunterStatFactory(equipment);
	}
	
	public WeaponSlot makeWeaponSlot(){
		return new HunterWeaponSlot();
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
		return new HunterSkillFactory();
	}
}
