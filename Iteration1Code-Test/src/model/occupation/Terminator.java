package model.occupation;

import view.AbilityView;
import model.*;
import model.abilities.Abilities;
import model.entity.Entity;
import model.items.equipment.EquipmentBuilder;
import model.slots.*;
import model.stats.factory.StatFactory;
import model.stats.factory.TerminatorStatFactory;
import model.visitor.OccupationVisitor;

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
	
	public Abilities createAbilities(){
		return new Abilities();
	}
	
	public AbilityView createAbilityView(){
		return new AbilityView();
	}

	@Override
	protected SkillFactory getSkillFactory() {
		return new TerminatorSkillFactory();
	}
	
	public void accept(OccupationVisitor visitor){
		visitor.accept(this);
	}
}
