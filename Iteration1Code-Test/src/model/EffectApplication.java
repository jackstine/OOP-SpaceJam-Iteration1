package model;

import model.Entity.Entity;
import model.items.DamagingOneShotItem;
import model.items.HealingOneShotItem;



public class EffectApplication{
	
	public static void apply(Entity entity, DeathAreaEffect areaEffect) {
		// DeathAoE affects Entity here
		entity.setStatValue("Lives", entity.getStatValue("Lives") - 1);
	}
	
	public static void apply(Entity entity, DamageAreaEffect areaEffect) {
		// DamageAoE affects Entity here
		entity.setStatValue("HP", (int)(entity.getStatValue("HP") * (1 - areaEffect.getPercentDamage())));
	}
	
	public static void apply(Entity entity, ExperienceAreaEffect areaEffect) {
		// ExperienceAoE affects Entity here
		entity.setStatValue("Experience", areaEffect.getExperience());
	}
	
	public static void apply(Entity entity, HealingAreaEffect areaEffect) {
		// HealingAoE affects Entity here
		entity.setStatValue("HP", (int)(entity.getStatValue("HP") * (1 + areaEffect.getPercentHealth())));
	}
	
	public static void apply(Entity entity, HealingOneShotItem item) {
		// Healing one-shot item affects Entity here
		entity.setStatValue("HP", (int)(entity.getStatValue("HP") * (1 + item.getPercentHealth())));
	}
	
	public static void apply(Entity entity, DamagingOneShotItem item) {
		// Damaging one-shot item affects Entity here
		entity.setStatValue("HP", (int)(entity.getStatValue("HP") * (1 - item.getPercentDamage())));
	}

}
