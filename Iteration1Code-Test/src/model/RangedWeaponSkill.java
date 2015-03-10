package model;

public class RangedWeaponSkill extends Skill {
	
	public RangedWeaponSkill() {
		super();
	}
	
	public String toString() {
		return "Ranged weapon:" + this.getSkillLevel();
	}
}
