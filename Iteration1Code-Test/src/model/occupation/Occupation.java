package model.occupation;

import java.util.Map;

import model.Skill;
import model.SkillFactory;
import model.entity.Entity;
import model.items.equipment.EquipmentBuilder;
import model.slots.Equipment;
import model.slots.WeaponSlot;
import model.stats.Stat;
import model.stats.factory.StatFactory;
import utilities.SpriteSheetUtility;

public abstract class Occupation{
	
	protected String portraitLocation;
	protected String name;
	protected Equipment equipment;
	protected Map<String, Stat> stats;
	protected Map<String, Skill> skills;
	
	
	public abstract Equipment createEquipment(EquipmentBuilder eb);
	public abstract Equipment createEmptyEquipment(EquipmentBuilder eb);
	public abstract WeaponSlot makeWeaponSlot();
	public abstract SpriteSheetUtility getSpriteSheet();
	public abstract void attack(Entity entity);
	
	protected abstract StatFactory getStatFactory(Equipment equipment);
	protected abstract SkillFactory getSkillFactory();
	
	public Map<String, Stat> getStats() {
		return this.stats;
	}
	
	public Map<String, Skill> getSkills() {
		return this.skills;
	}
	
	public Equipment getEquipment() {
		return this.equipment;
	}
	
	public void createNecessities(){
		EquipmentBuilder eb = new EquipmentBuilder();
		this.equipment = createEquipment(eb);
		
		StatFactory statFactory = this.getStatFactory(equipment);
		this.stats = statFactory.initializeStats();
		
		SkillFactory skillFactory = this.getSkillFactory();
		this.skills = skillFactory.initializeSkills();
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
}
