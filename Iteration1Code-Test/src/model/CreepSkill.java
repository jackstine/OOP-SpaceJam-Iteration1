package model;

public class CreepSkill extends Skill {
	
	public CreepSkill() {
		super();
	}
	
	public String toString() {
		return "Creep:" + this.getSkillLevel();
	}
}
