package model.behavior;

import utilities.Directions;
import utilities.RNG;
import model.entity.Entity;
import model.entity.EntityEffectHandler;
import model.items.TakeableItem;
import model.items.Weapon;
import model.items.Weapons;

public class PickPockit extends EngagedBehavior{
	private Entity pickPockiter;

	public PickPockit(Entity pickPockiter){
		this.pickPockiter = pickPockiter;
	}
	
	public void perform(Entity receiver) {
		pickPockiter.writeJournal(receiver.getDialogue());
		int oppositeDirection = Directions.getOppositeDirection(receiver.getDirection());
		pickPockiter.setDirection(oppositeDirection);
		
		int randomness = RNG.next(10);
		if (randomness < 5) {
			if (pickPockiter.getOccupation().getName().equals("Hunter")) {
				
				Weapon weapon;
				if (randomness <= 2) weapon = Weapons.LONGBOW.weapon;
				else if (randomness == 3) weapon = Weapons.DRAGONBOW.weapon;
				else weapon = Weapons.PRESTINEBOW.weapon;
				
				TakeableItem droppedItem = weapon;
				pickPockiter.getInventory().findAndEquip(droppedItem);
				pickPockiter.makeGoldTransaction(100);
			}			
		} else {	// on unsuccessful pickpockit the avatar takes damage
			EntityEffectHandler.applyDamage(pickPockiter, receiver.attack());
		}
	}

	public void getBuffs() {

	}

	public void kill() {
	}

}
