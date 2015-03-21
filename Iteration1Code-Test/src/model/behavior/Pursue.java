package model.behavior;

import controller.NPCMovementDirectiveController;
import model.entity.Entity;

public class Pursue extends EngagedBehavior{

	private NPCMovementDirectiveController movementController;
	private Entity pusuer;
	
	public Pursue(Entity pusuer){
		this.pusuer = pusuer;
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity receiver) {
		this.movementController = new NPCMovementDirectiveController(pusuer);
		movementController.setDirective("follow",receiver);
		this.movementController.doArtificialIntelligence();
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

	public void kill() {
		this.movementController.interrupt();
	}

}
