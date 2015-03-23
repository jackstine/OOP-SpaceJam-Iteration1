package controller;

import utilities.Directions;
import model.GameMap;
import model.RadialInfluenceSet;
import model.behavior.RadialEntitySight;
import model.entity.*;

public class NPCRangeController extends NPCSightController{
	private RadialEntitySight sight;
	private int radius;
	private NPCPingController pinger;
	
	public NPCRangeController(Entity entity, int radius) {
		super(entity, radius);
		this.radius = radius;
		pinger = new NPCPingController(entity);
	}
	
	public void doArtificialIntelligence() {
		task = new RangeTask();
		stopThread = false;
		task.start();
	}
	
	public void setSight(RadialEntitySight sight) {
		this.sight = sight;
	}
	
	private class RangeTask extends Thread {
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				while (!stopThread) {
						System.out.println("range extending from "+entity);
						pinger.pingRangeEstablished();
						if(sight==null) {
							sight = entity.getSight();
						}
						sight.setSight(new RadialInfluenceSet(map, map.getEntityTile(entity), radius, 0));
						if(sight.contains(sight.getTarget())) {
							pinger.pingInRangeOfTarget();
						}
						else pinger.pingOutOfRangeOfTarget();
					try{
						sleep(1000/entity.getStats().getStatValue("Movement"));
					}catch(Exception e){}
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
