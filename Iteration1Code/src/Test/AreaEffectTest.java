package Test;

import model.*;

public class AreaEffectTest {
	
	public static String[] keys = {"Agility", "ArmorRating", "DefensiveRating", 
								   "Experience", "Hardiness", "HP", "Intellect", 
								   "Level", "Life", "Lives", "Mana", "Movement", 
								   "MP", "OffensiveRating", "Strength"};
	
	public static void main(String[] args) {
		Avatar alchemist = new Avatar(new Alchemist());
		Avatar hunter = new Avatar(new Hunter());
		Avatar terminator = new Avatar(new Terminator());
		
		System.out.println("Terminator Stats:");
		printStats(terminator);
		//System.out.println("Hunter Stats:");
		//printStats(hunter);
		//System.out.println("Terminator Stats:");
		//printStats(terminator);
		
		AreaEffect deathAreaEffect = new DeathAreaEffect();
		AreaEffect damageAreaEffect = new DamageAreaEffect(0.5);
		AreaEffect healingAreaEffect = new HealingAreaEffect(0.5);
		AreaEffect experienceAreaEffect = new ExperienceAreaEffect();
		
		deathAreaEffect.apply(terminator);
		System.out.println("APPLIED DEATH AREA EFFECT!");
		System.out.println("Terminator Stats:");
		printStats(terminator);
		
		damageAreaEffect.apply(terminator);
		System.out.println("APPLIED DAMAGE AREA EFFECT!");
		System.out.println("Terminator Stats:");
		printStats(terminator);
		
		healingAreaEffect.apply(terminator);
		System.out.println("APPLIED HEALING AREA EFFECT!");
		System.out.println("Terminator Stats:");
		printStats(terminator);
		
		experienceAreaEffect.apply(terminator);
		System.out.println("APPLIED EXPERIENCE AREA EFFECT!");
		System.out.println("Terminator Stats:");
		printStats(terminator);
		
		experienceAreaEffect.apply(terminator);
		System.out.println("APPLIED EXPERIENCE AREA EFFECT!");
		System.out.println("Terminator Stats:");
		printStats(terminator);
	}
	
	public static void printStats(Entity entity) {
		for (String key : keys) {
			System.out.println("\t" + key + " - " + entity.getStatValue(key));
		}
		System.out.println("-------------------");
	}

}
