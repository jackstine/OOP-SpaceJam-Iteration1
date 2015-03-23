package model.occupation;

import java.util.Map;

import model.Skill;
import model.SkillFactory;
import model.abilities.Abilities;
import model.entity.Entity;
import model.items.equipment.EquipmentBuilder;
import model.slots.Equipment;
import model.slots.WeaponSlot;
import model.stats.Stat;
import model.stats.factory.StatFactory;
import model.visitor.OccupationVisitor;
import utilities.GoatSpriteSheetUtility;
import utilities.SpriteSheetUtility;
import view.AbilityView;

public abstract class Occupation{
	
	protected String portraitLocation;
	protected String name;
	protected Equipment equipment;
	protected Map<String, Stat> stats;
	protected Map<String, Skill> skills;
	protected Abilities abilities;
	protected AbilityView abilityView;
	
	
	public abstract Equipment createEquipment(EquipmentBuilder eb);
	public abstract Equipment createEmptyEquipment(EquipmentBuilder eb);
	public abstract WeaponSlot makeWeaponSlot();
	public abstract SpriteSheetUtility getSpriteSheet();
	public abstract void attack(Entity entity);
	public abstract Abilities createAbilities();
	public abstract AbilityView createAbilityView();
	
	protected abstract StatFactory getStatFactory(Equipment equipment);
	protected abstract SkillFactory getSkillFactory();
	
	public Abilities getAbilities(){
		return this.abilities;
	}
	
	public Map<String, Stat> getStats() {
		return this.stats;
	}
	
	public Map<String, Skill> getSkills() {
		return this.skills;
	}
	
	public Equipment getEquipment() {
		return this.equipment;
	}
	
	public AbilityView getAbilityView(){
		return this.abilityView;
	}
	
	public void createNecessities(){
		EquipmentBuilder eb = new EquipmentBuilder();
		this.equipment = createEquipment(eb);
		
		StatFactory statFactory = this.getStatFactory(equipment);
		this.stats = statFactory.initializeStats();
		
		SkillFactory skillFactory = this.getSkillFactory();
		this.skills = skillFactory.initializeSkills();
		
		this.abilities = this.createAbilities();
		this.abilityView = this.createAbilityView();
	}
	
	public void createEmptyNecessities() {
		EquipmentBuilder eb = new EquipmentBuilder();
		this.equipment = createEmptyEquipment(eb);
	}
	
	public String getPortraitLocation() {
		return portraitLocation;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Occupation:" + this.name;
	}
	
	public abstract void accept(OccupationVisitor visitor);
	public SpriteSheetUtility getTransformedSpriteSheet() {
		return null;
	}
	public SpriteSheetUtility getAlternateSpriteSheet() {
		return new GoatSpriteSheetUtility();
	}
}
