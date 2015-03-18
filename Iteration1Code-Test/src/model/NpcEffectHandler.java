package model;

import java.util.Random;

import utilities.Directions;

import model.Entity.*;
import model.items.*;

public class NpcEffectHandler {
	
	public static void apply(Avatar avatar, Orc npc) {
		npc.getAreaEffect().apply(avatar);
		int oppositeDirection = getOppositeDirection(avatar);
		npc.setDirection(oppositeDirection);
	}
	
	public static void apply(Avatar avatar, Skeleton npc) {
		avatar.writeJournal(npc.getDialogue());
		int oppositeDirection = getOppositeDirection(avatar);
		npc.setDirection(oppositeDirection);
		
		int randomness = randomNumber();
		if (randomness < 5) {
			System.out.println("You can not steal");
			if (avatar.getOccupation().getName().equals("Hunter")) {
				System.out.println("Steal Success");
				
				Weapon weapon;
				if (randomness <= 2) weapon = Weapons.LONGBOW.weapon;
				else if (randomness == 3) weapon = Weapons.DRAGONBOW.weapon;
				else weapon = Weapons.PRESTINEBOW.weapon;
				
				TakeableItem droppedItem = weapon;
				avatar.getInventory().findAndEquip(droppedItem);
			}			
		} else {			
			npc.getAreaEffect().apply(avatar); 
			System.out.println("Steal failure");
		}
	}
	
	public static void apply(Avatar avatar, Merchant npc) {
		avatar.writeJournal(npc.getDialogue());
		int oppositeDirection = getOppositeDirection(avatar);
		npc.setDirection(oppositeDirection);
	}
	
	private static int getOppositeDirection(Avatar avatar) {
		return Directions.getOppositeDirection(avatar.getDirection());
	}
	
	private static int randomNumber() {
		Random rand = new Random();
		return rand.nextInt()%10;
	}
	
}
