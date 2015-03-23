package model.occupation;

import view.AbilityView;
import view.SpellView;
import model.*;
import model.abilities.Abilities;
import model.abilities.Spells;
import model.entity.Entity;
import model.items.equipment.EquipmentBuilder;
import model.slots.*;
import model.stats.factory.AlchemistStatFactory;
import model.stats.factory.StatFactory;
import model.visitor.OccupationVisitor;

public abstract class Alchemist extends Occupation{
	
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
	
	public Abilities createAbilities(){
		return new Spells();
	}
	
	public AbilityView createAbilityView(){
		return new SpellView();
	}

	@Override
	protected SkillFactory getSkillFactory() {
		return new AlchemistSkillFactory();
	}
	
	public void accept(OccupationVisitor visitor){
		visitor.accept(this);
	}
}
