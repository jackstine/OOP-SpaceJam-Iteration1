package model;

public class EffectApplication {
	
	public static void apply(Entity entity, DeathAreaEffect areaEffect) {
		// DeathAoE affects Entity here
		entity.setStatValue("Lives", entity.getStatValue("Lives") - 1);
	}
	
	public static void apply(Entity entity, DamageAreaEffect areaEffect) {
		// DamageAoE affects Entity here
		entity.setStatValue("Life", (int)(entity.getStatValue("Life") * (1 - areaEffect.getPercentDamage())));
	}
	
	public static void apply(Entity entity, ExperienceAreaEffect areaEffect) {
		// ExperienceAoE affects Entity here
		entity.setStatValue("Experience", areaEffect.getExperience());
	}
	
	public static void apply(Entity entity, HealingAreaEffect areaEffect) {
		// HealingAoE affects Entity here
		entity.setStatValue("Life", (int)(entity.getStatValue("Life") * (1 + areaEffect.getPercentHealth())));
	}

}
