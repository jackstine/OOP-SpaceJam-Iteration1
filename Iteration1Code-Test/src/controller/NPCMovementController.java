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
	
	public NPCMovementController(Entity entity){
		//this.mapView = mapView;
		this.entity = entity;
	}
	
	public GameMap getCurrMap(){
		System.out.println(World.getMap("Main"));
		return World.getMap(entity.getCurrMap());
	}
	
	public Location getEntityLocation(){
		return getCurrMap().getLocation(entity);
	}
	
	public void doArtificialIntelligence() {
		Thread task = new CircleTask();
		task.run();
	}
	
	private class CircleTask extends Thread {
		//Entity entity = getNPC();
		GameMap map = getCurrMap();
		Tile tile;
		
		@Override
		public void run() {
			while (true) {
				
				System.out.println(map);
				tile = map.getEntityTile(entity);
				if (tile != null) {
					move(MovementController.WEST, Directions.WEST);
				}
				
				System.out.println("AI RUNNING AND IN A LOOP");
				
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}

	@Override
	public void move(Point step, int direction) {
		//Location entityLocation = this.getEntityLocation();
		Location pointToMove = new Location(this.getEntityLocation());
		pointToMove.addLocation(step);
		entity.setDirection(direction);
		if(this.getCurrMap().isPassable(pointToMove)){
			getCurrMap().updateEntityLocation(entity, pointToMove);
		}
		//System.out.println(this.getCurrMap().getTile(entityLocation).getTerrain());
		//this.mapView.repaint();
	}

	
}
