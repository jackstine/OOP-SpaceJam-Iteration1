package Test;

import model.*;

public class AreaEffectTest {
	
	public static String[] keys = {"Agility", "ArmorRating", "DefensiveRating", "Experience", "Hardiness", "HP", "Intellect", "Level", "Life", "Lives", "Mana", "Movement", "OffensiveRating", "Strength"};
	
	public static void main(String[] args) {
		Entity alchemist = new Avatar(new Alchemist());
		Entity hunter = new Avatar(new Hunter());
		Entity terminator = new Avatar(new Terminator());
		
		System.out.println("Alchemist Stats:");
		printStats(alchemist);
		//System.out.println("Hunter Stats:");
		//printStats(hunter);
		//System.out.println("Terminator Stats:");
		//printStats(terminator);
		
		AreaEffect deathAreaEffect = new DeathAreaEffect();
		AreaEffect damageAreaEffect = new DamageAreaEffect(0.5);
		AreaEffect healingAreaEffect = new HealingAreaEffect(0.5);
		AreaEffect experienceAreaEffect = new ExperienceAreaEffect(500);
		
		deathAreaEffect.apply(alchemist);
		System.out.println("APPLIED DEATH AREA EFFECT!");
		System.out.println("Alchemist Stats:");
		printStats(alchemist);
		
		damageAreaEffect.apply(alchemist);
		System.out.println("APPLIED DAMAGE AREA EFFECT!");
		System.out.println("Alchemist Stats:");
		printStats(alchemist);
		
		healingAreaEffect.apply(alchemist);
		System.out.println("APPLIED HEALING AREA EFFECT!");
		System.out.println("Alchemist Stats:");
		printStats(alchemist);
		
		experienceAreaEffect.apply(alchemist);
		System.out.println("APPLIED EXPERIENCE AREA EFFECT!");
		System.out.println("Alchemist Stats:");
		printStats(alchemist);
	}
	
	public static void printStats(Entity entity) {
		for (String key : keys) {
			System.out.println("\t" + key + " - " + entity.getStatValue(key));
		}
		System.out.println("-------------------");
	}

}
