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
		//System.out.println(World.getMap("Main"));
		return World.getMap(entity.getCurrMap());
	}
	
	public Location getEntityLocation(){
		//System.out.println(getCurrMap().getLocation(entity));
		return getCurrMap().getLocation(entity);
	}
	
	public void doArtificialIntelligence() {
		Thread task = new CircleTask();
		task.start();
	}
	
	private class CircleTask extends Thread {
		//Entity entity = getNPC();
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			int i = 0;
			while (i < 5) {
				//System.out.println(map+"aye");
				//tile = map.getEntityTile(entity);
				//if (tile != null) {
					move(MovementController.WEST, Directions.WEST);
				//
				
				try {
					Thread.sleep(10000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}

	@Override
	public void move(Point step, int direction) {
		//Location entityLocation = this.getEntityLocation();
		System.out.println("I AM LOOKING AT A "+entity);
		System.out.println(this.getEntityLocation()+"WHERE IS THIS ENTITY");
		
		Location pointToMove = new Location(this.getEntityLocation());
		pointToMove.addLocation(step);
		entity.setDirection(direction);
		//if(this.getCurrMap().isPassable(pointToMove)){
			getCurrMap().updateEntityLocation(entity, pointToMove);
			System.out.println("I HAVE MOOOOVED");
		//}
		//System.out.println(this.getCurrMap().getTile(entityLocation).getTerrain());
		//this.mapView.repaint();
	}

	
}
