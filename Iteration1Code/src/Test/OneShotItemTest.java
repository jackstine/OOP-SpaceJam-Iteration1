package Test;

import model.*;

public class OneShotItemTest {
	
	public static String[] keys = {"Agility", "ArmorRating", "DefensiveRating", 
		   						   "Experience", "Hardiness", "HP", "Intellect", 
		   						   "Level", "Life", "Lives", "Mana", "Movement", 
		   						   "OffensiveRating", "Strength"};
	
	public static void main(String[] args) {
		OneShotItem healingOneShotItem = new HealingOneShotItem(0.5);
		OneShotItem damagingOneShotItem = new DamagingOneShotItem(0.5);
		Entity alchemist = new Avatar(new Alchemist());
		printStats(alchemist);
		
		System.out.println("APPLIED DAMAGING ONE-SHOT ITEM!");
		damagingOneShotItem.action(alchemist);
		printStats(alchemist);
		
		System.out.println("APPLIED HEALING ONE-SHOT ITEM!");
		healingOneShotItem.action(alchemist);
		printStats(alchemist);
		
	}
	
	public static void printStats(Entity entity) {
		for (String key : keys) {
			System.out.println("\t" + key + " - " + entity.getStatValue(key));
		}
		System.out.println("-----------------------");
	}

}
