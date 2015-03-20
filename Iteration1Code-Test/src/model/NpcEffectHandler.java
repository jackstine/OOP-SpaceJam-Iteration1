package model;


import utilities.Directions;
import utilities.RNG;
import model.entity.*;
import model.items.*;

public class NpcEffectHandler {
	
	public static void apply(Avatar avatar, Orc npc) {
		EntityEffectHandler.applyDamage(avatar, npc.attack());
		int oppositeDirection = getOppositeDirection(avatar);
		npc.setDirection(oppositeDirection);
	}
	
	public static void apply(Avatar avatar, Skeleton npc) {
		avatar.writeJournal(npc.getDialogue());
		int oppositeDirection = getOppositeDirection(avatar);
		npc.setDirection(oppositeDirection);
		
		int randomness = RNG.next(10);
		System.out.println(randomness);
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
		} else {	// on unsuccessful pickpockit the avatar takes damage
			int damage = 5;
			EntityEffectHandler.applyDamage(avatar, damage);
			System.out.println("Steal failure");
		}
	}
	
	public static void apply(Avatar avatar, Merchant npc) {
		avatar.writeJournal(npc.getDialogue());
		int oppositeDirection = getOppositeDirection(avatar);
		npc.setDirection(oppositeDirection);
		npc.getMerchantView().showMerchantView();
	}
	
	private static int getOppositeDirection(Avatar avatar) {
		return Directions.getOppositeDirection(avatar.getDirection());
	}
	
	
}
