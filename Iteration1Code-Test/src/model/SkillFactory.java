package model;

import java.util.HashMap;
import java.util.Map;

public abstract class SkillFactory {
	
	private Map<String, Skill> map;
	
	public final Map<String, Skill> initializeSkills() {
		this.map = createOccupationSkills();
		createGeneralSkills();
		return this.map;
	}
	
	private void createGeneralSkills() {
		Skill bindWounds = new BindWoundsSkill();
		Skill bargain = new BargainSkill();
		Skill observation = new ObservationSkill();
		
		this.map.put("BindWounds", bindWounds);
		this.map.put("Bargain", bargain);
		this.map.put("Observation", observation);
	}
	
	protected abstract Map<String, Skill> createOccupationSkills();
}
