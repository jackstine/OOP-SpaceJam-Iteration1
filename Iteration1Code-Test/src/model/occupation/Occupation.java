package model.occupation;

import java.util.Map;

import model.Entity;
import model.EquipmentBuilder;
import model.Skill;
import model.SkillFactory;
import model.Stat;
import model.StatFactory;
import model.slots.Equipment;
import model.slots.WeaponSlot;

public abstract class Occupation{
	
	protected String portraitLocation;
	protected String name;
	protected Equipment equipment;
	protected Map<String, Stat> stats;
	protected Map<String, Skill> skills;
	
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
	
	public abstract Equipment createEquipment(EquipmentBuilder eb);
	public abstract WeaponSlot makeWeaponSlot();
	
	protected abstract StatFactory getStatFactory(Equipment equipment);
	protected abstract SkillFactory getSkillFactory();
	
	public String getPortraitLocation() {
			return portraitLocation;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Occupation:" + this.name;
	}
	
	public abstract void attack(Entity entity);
}
