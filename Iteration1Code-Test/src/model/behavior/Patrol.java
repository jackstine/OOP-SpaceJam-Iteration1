package model.behavior;

import java.util.ArrayList;

import controller.NPCMovementController;
import controller.NPCMovementLoopController;
import model.entity.Entity;

public class Patrol extends IdleBehavior{

	private int patrolDistance;
	private NPCMovementLoopController movementController;
	private Entity entity;
	
	public Patrol(Entity entity){
		this.entity = entity;
	}
	
	public Patrol(Entity entity, int patrolDistance){
		this.entity = entity;
		this.patrolDistance = patrolDistance;
	}
	
	public Patrol(int patrolDistance) {
		this.patrolDistance = patrolDistance;
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity receiver) {
		this.movementController = new NPCMovementLoopController(entity);
		movementController.setMovementLoop(patrolLoop());
		this.movementController.doArtificialIntelligence();
		System.out.println("doing ai");
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<String> patrolLoop() {
		ArrayList<String> directives = new ArrayList<String>();
		for(int i = 0; i < patrolDistance; i++) {
			directives.add("forward");
		}
		directives.add("clockwise");
		return directives;
	}

	public void kill() {
		this.movementController.interrupt();
	}

}
