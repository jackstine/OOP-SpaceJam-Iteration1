package controller;

import utilities.Directions;
import model.GameMap;
import model.RadialInfluenceSet;
import model.behavior.RadialEntitySight;
import model.entity.*;

public class NPCSightController extends NPCController{
	private RadialEntitySight sight;
	private int radius;
	private boolean hasFoundTarget = false;
	
	public NPCSightController(Entity entity, int radius) {
		super(entity);
		this.radius = radius;
	}
	
	public void doArtificialIntelligence() {
		task = new SightTask();
		stopThread = false;
		task.start();
	}
	
	public boolean hasFoundTarget() {
		return hasFoundTarget;
	}
	
	public void setSight(RadialEntitySight sight) {
		this.sight = sight;
	}
	
	private class SightTask extends Thread {
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				while (!stopThread) {
						if(sight==null) {
							sight = entity.getSight();
						}
						radius = entity.getStatValue("Sight");
						sight.setSight(new RadialInfluenceSet(map, map.getEntityTile(entity), radius, 0));
						//System.out.println("sight extending from "+entity);
						if(sight.contains(sight.getTarget())) {
							//System.out.println("I FOUND EM");
							hasFoundTarget = true;
							yield();
						}
					try{
						sleep(1000/entity.getStats().getStatValue("Movement"));
					}catch(Exception e){}
				}
			} 
			catch (Exception e) {
			}
		}
	}
}
