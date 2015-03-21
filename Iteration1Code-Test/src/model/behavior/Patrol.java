package model.behavior;

import controller.NPCMovementController;
import model.entity.Entity;

public class Patrol extends IdleBehavior{

	private int patrolDistance;
	private NPCMovementController movementController;
	
	public Patrol(int patrolDistance) {
		this.patrolDistance = patrolDistance;
		//this.movementController = new NPCMovementController();
	}
	
	@Override
	public void perform(Entity initiate, Entity receiver) {
		//movementController.move(initiate);
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

}
