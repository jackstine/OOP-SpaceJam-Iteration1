package model;

public class BrawlingSkill extends Skill {
	
	public BrawlingSkill() {
		super();
	}
	
	public String toString() {
		return "Brawling:" + this.getSkillLevel();
	}
}
