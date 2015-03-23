package model.behavior;

import java.util.ArrayList;

import controller.NPCMovementController;
import controller.NPCMovementLoopController;
import controller.NPCRangeController;
import controller.NPCSightController;
import model.entity.Entity;
import model.entity.NPC;

public class RangeTrack extends IdleBehavior{

	private NPCRangeController rangeController;
	private Entity entity;
	
	public RangeTrack(Entity entity){
		this.entity = entity;
	}
	
	public RangeTrack() {
		
	}

	public void setSight(RadialEntitySight sight) {
		rangeController.setSight(sight);
	}
	
	public void track(Entity entity) {
		this.entity = entity;
		if(rangeController != null) kill();
	}
	
	//TODO I think that Idle Behaviors will not take in a Entity
	public void perform(Entity receiver) {
		this.rangeController = new NPCRangeController(entity,1);
		this.rangeController.setSight(entity.getSight());
		this.rangeController.doArtificialIntelligence();
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}

	public void kill() {
		System.out.println("range killed");
		this.rangeController.interrupt();
	}

}
