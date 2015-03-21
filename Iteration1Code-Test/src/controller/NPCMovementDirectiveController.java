package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import utilities.Directions;
import model.GameMap;
import model.Location;
import model.Tile;
import model.entity.Entity;

public class NPCMovementDirectiveController extends NPCMovementController{
	private String directive;
	private Entity target;
	
	public NPCMovementDirectiveController(Entity entity){
		//this.mapView = mapView;
		super(entity);
	}
	
	public void doArtificialIntelligence() {
		task = new DirectiveTask();
		stopThread = false;
		task.start();
	}
	
	public void setDirective(String directive, Entity target) {
		this.directive = directive;
		this.target = target;
	}
	
	private class DirectiveTask extends Thread {
		//Entity entity = getNPC();
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				while ((! interrupted()) && !stopThread) {
					if(directive.equals("follow")) {
						Location targetLoc = map.getEntityLocation(target);
						Location currentLoc = map.getEntityLocation(entity);
						int targetX = targetLoc.getX();
						int targetY = targetLoc.getY();
						int currentX = currentLoc.getX();
						int currentY = currentLoc.getY();
						
						if(currentX > targetX) {
							//moveleft
							entity.setDirection(Directions.WEST);
							move(MovementController.WEST,Directions.WEST);
						}
						else if(currentX < targetX) {
							//moveright
							entity.setDirection(Directions.EAST);
							move(MovementController.EAST,Directions.EAST);
						}
						else if(currentY > targetY) {
							//moveup
							entity.setDirection(Directions.NORTH);
							move(MovementController.NORTH,Directions.NORTH);
						}
						else if(currentY < targetY) {
							//movedown
							entity.setDirection(Directions.SOUTH);
							move(MovementController.SOUTH,Directions.SOUTH);
						}
					}
					try{
						sleep(10000/entity.getStats().getStatValue("Movement"));
					}catch(Exception e){}
				}
			} catch (Exception e) {
			}
			
			
		}
	}
}
