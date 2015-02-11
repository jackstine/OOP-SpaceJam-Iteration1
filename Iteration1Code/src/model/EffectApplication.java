package model;

public class EffectApplication {
	
	public static void apply(Entity e, DeathAreaEffect af) {
		// DeathAoE affects Entity here
		e.setStatValue("Lives", e.getStatValue("Lives") - 1);
	}
	
	public static void apply(Entity e, DamageAreaEffect af) {
		// DamageAoE affects Entity here
		e.setStatValue("Life", (int)(e.getStatValue("Life") * (1 - af.getPercentDamage())));
	}
	
	public static void apply(Entity e, ExperienceAreaEffect af) {
		// ExperienceAoE affects Entity here
		e.setStatValue("Experience", af.getExperience());
	}
	
	public static void apply(Entity e, HealingAreaEffect af) {
		// HealingAoE affects Entity here
		e.setStatValue("Life", (int)(e.getStatValue("Life") * (1 + af.getPercentHealth())));
	}

}
