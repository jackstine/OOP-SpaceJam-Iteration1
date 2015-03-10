package model;

public class TwoHandedWeaponSkill extends Skill {
	
	public TwoHandedWeaponSkill() {
		super();
	}
	
	public String toString() {
		return "TwoHandedWeapon:" + this.getSkillLevel();
	}
}
