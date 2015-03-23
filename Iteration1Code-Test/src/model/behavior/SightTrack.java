package model.behavior;

import java.util.ArrayList;

import controller.NPCMovementController;
import controller.NPCMovementLoopController;
import controller.NPCRangeController;
import controller.NPCSightController;
import model.entity.Entity;
import model.entity.NPC;

public class SightTrack extends ConstantBehavior{

	private NPCSightController sightController;
	private Entity entity;
	
	public SightTrack(Entity entity){
		this.entity = entity;
	}
	
	public SightTrack() {
		
	}
	
	public void track(Entity entity) {
		this.entity = entity;
		if(sightController != null) kill();
	}

	public void setSight(RadialEntitySight sight) {
		sightController.setSight(sight);
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity receiver) {
		this.sightController = new NPCSightController(entity,3);
		this.sightController.setSight(entity.getSight());
		this.sightController.doArtificialIntelligence();
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

	public void kill() {
		System.out.println("range killed");
		this.sightController.interrupt();
	}

}
