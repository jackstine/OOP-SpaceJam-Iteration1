package model;

public class BargainSkill extends Skill {
	
	public BargainSkill() {
		super();
	}
	
	public String toString() {
		return "Bargain:" + this.getSkillLevel();
	}
}
