package model;

public class BaneSkill extends Skill {
	
	public BaneSkill() {
		super();
	}
	
	public String toString() {
		return "Bane:" + this.getSkillLevel();
	}
}
