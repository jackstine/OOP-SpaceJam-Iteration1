package model;

public class ObservationSkill extends Skill {

	public ObservationSkill() {
		super();
	}
	
	public String toString() {
		return "Observation:" + this.getSkillLevel();
	}
}
