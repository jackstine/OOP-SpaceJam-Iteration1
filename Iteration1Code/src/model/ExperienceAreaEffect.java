package model;

public class ExperienceAreaEffect implements AreaEffect{

	private int experience;
	
	public ExperienceAreaEffect(int experience) {
		this.experience = experience;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public void apply(Entity entity) {
		
		EffectApplication.apply(entity, this);
		
	}
	
}
