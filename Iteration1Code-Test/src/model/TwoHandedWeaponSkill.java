package model;

public class TwoHandedWeaponSkill extends Skill {
	
	public TwoHandedWeaponSkill() {
		super();
	}
	
	public String toString() {
		return "Two-handed weapon:" + this.getSkillLevel();
	}
}
