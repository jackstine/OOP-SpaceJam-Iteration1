package model.occupation;


import utilities.SpriteSheetUtility;
import view.AbilityView;
import view.SneekyView;
import model.*;
import model.abilities.Abilities;
import model.abilities.Sneeky;
import model.entity.Entity;
import model.items.equipment.EquipmentBuilder;
import model.slots.*;
import model.stats.factory.HunterStatFactory;
import model.stats.factory.StatFactory;
import model.visitor.OccupationVisitor;

public abstract class Hunter extends Occupation{

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
	
	public void detect(){
		
	}
	
	public Abilities createAbilities(){
		return new Sneeky();
	}
	
	public AbilityView createAbilityView(){
		return new SneekyView();
	}
	
	@Override
	protected SkillFactory getSkillFactory() {
		return new HunterSkillFactory();
	}
	
	public void accept(OccupationVisitor visitor){
		visitor.accept(this);
	}
	
}
