package model;

import java.io.Serializable;

public class ExperienceAreaEffect implements AreaEffect, Serializable {

	private int experience;
	
	public ExperienceAreaEffect() {}
	
	public int getExperience() {
		return this.experience;
	}
	
	public void apply(Entity entity) {
		int level = entity.getStatValue("Level");
		this.experience = 25 * (level + 1) * level;
		EffectApplication.apply(entity, this);		
	}
	
}
