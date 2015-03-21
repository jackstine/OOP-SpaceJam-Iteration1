package model.behavior;

import controller.NPCMovementController;
import model.entity.Entity;

public class Patrol extends IdleBehavior{

	private int patrolDistance;
	private NPCMovementController movementController;
	private Entity entity;
	
	public Patrol(Entity entity){
		this.entity = entity;
	}
	
	public Patrol(int patrolDistance) {
		this.patrolDistance = patrolDistance;
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity initiate, Entity receiver) {
		NPCMovementController moveme = new NPCMovementController(entity);
		moveme.doArtificialIntelligence();
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

}
