package model.behavior;

import controller.NPCMovementDirectiveController;
import controller.NPCPursueController;
import model.entity.Entity;
import model.entity.NPC;

public class Pursue extends EngagedBehavior{

	private NPCPursueController movementController;
	private Entity entity;
	
	public Pursue(Entity entity){
		this.entity = entity;
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity receiver) {
		this.movementController = new NPCPursueController(entity);
		movementController.setTarget(receiver);
		this.movementController.doArtificialIntelligence();
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

	public void kill() {
		System.out.println(movementController);
		this.movementController.interrupt();
	}

}
