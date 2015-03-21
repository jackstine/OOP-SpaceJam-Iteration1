package model.occupation;

import utilities.SpriteSheetUtility;
import model.*;
import model.entity.Entity;
import model.items.equipment.EquipmentBuilder;
import model.slots.*;
import model.spells.Spells;
import model.stats.factory.StatFactory;
import model.stats.factory.TerminatorStatFactory;

public abstract class Terminator extends Occupation{

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
	
	public Spells createSpells(){
		return null;
	}

	@Override
	protected SkillFactory getSkillFactory() {
		return new TerminatorSkillFactory();
	}
}
