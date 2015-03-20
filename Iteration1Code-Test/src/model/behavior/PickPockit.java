package model.behavior;

import utilities.Directions;
import utilities.RNG;
import model.entity.Entity;
import model.entity.EntityEffectHandler;
import model.items.TakeableItem;
import model.items.Weapon;
import model.items.Weapons;

public class PickPockit implements Behavior{

	public PickPockit(){}
	
	public void perform(Entity initiate, Entity receiver) {
		initiate.writeJournal(receiver.getDialogue());
		int oppositeDirection = Directions.getOppositeDirection(receiver.getDirection());
		initiate.setDirection(oppositeDirection);
		
		int randomness = RNG.next(10);
		System.out.println(randomness);
		if (randomness < 5) {
			System.out.println("You can not steal");
			if (initiate.getOccupation().getName().equals("Hunter")) {
				System.out.println("Steal Success");
				
				Weapon weapon;
				if (randomness <= 2) weapon = Weapons.LONGBOW.weapon;
				else if (randomness == 3) weapon = Weapons.DRAGONBOW.weapon;
				else weapon = Weapons.PRESTINEBOW.weapon;
				
				TakeableItem droppedItem = weapon;
				initiate.getInventory().findAndEquip(droppedItem);
			}			
		} else {	// on unsuccessful pickpockit the avatar takes damage
			int damage = 5;
			EntityEffectHandler.applyDamage(initiate, receiver.attack());
			System.out.println("Steal failure");
		}
	}

	public void getBuffs() {

	}

}
