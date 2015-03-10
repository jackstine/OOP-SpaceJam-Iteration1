package model;

public class BoonSkill extends Skill {

	public BoonSkill() {
		super();
	}
	
	public String toString() {
		return "Boon:" + this.getSkillLevel();
	}
}
