package controller;

import utilities.Directions;
import model.GameMap;
import model.RadialInfluenceSet;
import model.behavior.RadialEntitySight;
import model.entity.Entity;

public class NPCSightController extends NPCController{
	private RadialEntitySight sight;
	
	public NPCSightController(Entity entity) {
		super(entity);
	}
	
	public void doArtificialIntelligence() {
		task = new SightTask();
		stopThread = false;
		task.start();
	}
	
	public void setSight(RadialEntitySight sight) {
		this.sight = sight;
	}
	
	private class SightTask extends Thread {
		//Entity entity = getNPC();
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				while ((! interrupted()) && !stopThread) {
						if(sight==null) {
							sight = entity.getSight();
						}
						sight.setSight(new RadialInfluenceSet(map, map.getEntityTile(entity), 3, 0));
						if(sight.contains(sight.getTarget())) {
							System.out.println("found you bb");
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
