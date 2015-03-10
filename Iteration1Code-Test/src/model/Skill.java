package model;

public abstract class Skill {
	
	private int skillLevel;
	
	public Skill() {
		this.skillLevel = 1;
	}
	
	public void upgradeSkillLevel() {
		this.skillLevel++;
	}
	
	public int getSkillLevel() {
		return this.skillLevel;
	}
}
