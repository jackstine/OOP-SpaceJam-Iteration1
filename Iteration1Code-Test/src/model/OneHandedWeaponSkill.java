package model;

public class OneHandedWeaponSkill extends Skill {
	
	public OneHandedWeaponSkill() {
		super();
	}
	
	public String toString() {
		return "One-handed weapon:" + this.getSkillLevel();
	}
}
