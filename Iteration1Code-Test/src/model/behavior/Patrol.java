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
		//this.movementController = new NPCMovementController();
	}
	
//	for(String s : mapNames) {
//	GameMap curMap = world.getMap(s);
//	HashMap<Entity,Location> entityMap = curMap.getEntityToLocationMap();
//	Set<Entity> entities = entityMap.keySet();
//	for(Entity e : entities) {
//		System.out.println(e);
//		System.out.println("PRINTING THIS");
//		if(!(e instanceof Avatar)) {
//			NPCMovementController moveme = new NPCMovementController(e);
//			moveme.doArtificialIntelligence();
//		}
//	}
//}
	
	@Override
	public void perform(Entity initiate, Entity receiver) {
		//movementController.move(initiate);
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

}
