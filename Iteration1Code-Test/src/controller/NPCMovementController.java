package controller;

import utilities.Directions;
import view.MapView;
import model.entity.*;
import model.GameMap;
import model.Location;
import model.Point;
import model.QuestHandler;
import model.Tile;
import model.World;

public class NPCMovementController extends MovementController {

	private Entity entity;
	private Thread task;
	
	public NPCMovementController(Entity entity){
		//this.mapView = mapView;
		this.entity = entity;
	}
	
	public GameMap getCurrMap(){
		return World.getMap(entity.getCurrMap());
	}
	
	public Location getEntityLocation(){
		return getCurrMap().getLocation(entity);
	}
	
	public void doArtificialIntelligence() {
		task = new CircleTask();
		task.start();
	}
	
	public void interrupt(){
		try{
			this.task.interrupt();
		}catch(Exception e){}
	}
	
	private class CircleTask extends Thread {
		//Entity entity = getNPC();
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				int i = 0;
				while (i < 5 && (! interrupted())) {
					//System.out.println(map+"aye");
					//tile = map.getEntityTile(entity);
					//if (tile != null) {
						move(MovementController.WEST, Directions.WEST);
	
					try{
						sleep(5000);
					}catch(Exception e){}
	
				}
			} catch (Exception e) {
			}
			
			
		}
	}

	public void move(Point step, int direction) {		
		Location pointToMove = new Location(this.getEntityLocation());
		pointToMove.addLocation(step);
		entity.setDirection(direction);
		getCurrMap().updateEntityLocation(entity, pointToMove);
	}

	
}
