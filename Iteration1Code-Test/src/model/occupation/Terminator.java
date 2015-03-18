package model.occupation;

import utilities.SpriteSheetUtility;
import model.*;
import model.Entity.Entity;
import model.slots.*;

public class Terminator extends Occupation{

	public Terminator() {
		this.portraitLocation = "src/res/img/terminator_portrait.jpg";
		this.name = "Terminator";
	}
	
	protected StatFactory getStatFactory(Equipment equipment){
		return new TerminatorStatFactory(equipment);
	}
	
	public WeaponSlot makeWeaponSlot(){
		return new TerminatorWeaponSlot();
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
		return new TerminatorSkillFactory();
	}
}
