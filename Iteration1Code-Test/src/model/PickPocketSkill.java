package model;

public class PickPocketSkill extends Skill {
	
	public PickPocketSkill() {
		super();
	}
	
	public String toString() {
		return "PickPocket:" + this.getSkillLevel();
	}
}
