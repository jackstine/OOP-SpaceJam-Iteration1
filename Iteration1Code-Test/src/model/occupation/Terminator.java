package model.occupation;

import model.*;
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
	
	public void attack(Entity entity) {
		// create "CombatSimulator" class that will carry
		// out the fighting between Avatar and Entity		
	}

	@Override
	protected SkillFactory getSkillFactory() {
		return new TerminatorSkillFactory();
	}
}
