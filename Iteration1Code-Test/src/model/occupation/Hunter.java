package model.occupation;


import model.*;
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
	
	public void attack(Entity entity) {
		// create "CombatSimulator" class that will carry
		// out the fighting between Avatar and Entity		
	}

	@Override
	protected SkillFactory getSkillFactory() {
		return new HunterSkillFactory();
	}
}
