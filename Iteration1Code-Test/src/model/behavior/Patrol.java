package model.behavior;

import java.util.ArrayList;

import controller.NPCMovementController;
import controller.NPCMovementLoopController;
import controller.NPCSightController;
import model.entity.Entity;

public class Patrol extends IdleBehavior{

	private int patrolDistance;
	private NPCMovementLoopController movementController;
	private NPCSightController sightController;
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
	
	public void setSight(RadialEntitySight sight) {
		sightController.setSight(sight);
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity receiver) {
		this.movementController = new NPCMovementLoopController(entity);
		this.sightController = new NPCSightController(entity);
		movementController.setMovementLoop(patrolLoop());
		this.sightController.setSight(entity.getSight());
		this.movementController.doArtificialIntelligence();
		this.sightController.doArtificialIntelligence();
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
