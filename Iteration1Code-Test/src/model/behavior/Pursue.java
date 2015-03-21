package model.behavior;

import java.util.ArrayList;

import controller.NPCMovementController;
import model.entity.Entity;

public class Pursue extends IdleBehavior{

	private NPCMovementController movementController;
	private Entity entity;
	
	public Pursue(Entity entity){
		this.entity = entity;
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity initiate, Entity receiver) {
		//this.movementController = new NPCMovementController(entity);
		//movementController.setMovementLoop(patrolLoop());
		//this.movementController.doArtificialIntelligence();
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

	public void kill() {
		this.movementController.interrupt();
	}

}
