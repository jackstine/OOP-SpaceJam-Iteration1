package model;

public class StaffSkill extends Skill {
	
	public StaffSkill() {
		super();
	}
	
	public String toString() {
		return "Staff:" + this.getSkillLevel();
	}
}
