package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import utilities.Directions;
import model.GameMap;
import model.Location;
import model.Point;
import model.Tile;
import model.entity.*;

public class NPCPursueController extends NPCMovementDirectiveController{
	private Entity target;
	NPCPingController pinger;
	
	public NPCPursueController(Entity entity){
		super(entity);
		pinger = new NPCPingController(entity);
		target = entity.getSight().getTarget();
	}
	
	public void doArtificialIntelligence() {
		task = new PursuitTask();
		stopThread = false;
		//System.out.println("starting pursuit");
		task.start();
	}
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	private class PursuitTask extends Thread {
		//Entity npc = getNPC();
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				while (!stopThread) {
					//System.out.println("here we go");
					target = entity.getSight().getTarget();
					Location targetLoc = map.getEntityLocation(target);
					Location currentLoc = map.getEntityLocation(entity);
					int targetX = targetLoc.getX();
					int targetY = targetLoc.getY();
					int currentX = currentLoc.getX();
					int currentY = currentLoc.getY();
					//System.out.println("for da hundreth time");
					//System.out.println(target + "FDJSKL" + entity);
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
					
					try{
						sleep(10000/entity.getStats().getStatValue("Movement"));
					}catch(Exception e){}
				}
			} catch (Exception e) {
			}
		}
	}
	
	public void move(Point step, int direction) {	
		Location pointToMove = new Location(this.getEntityLocation());
		pointToMove.addLocation(step);
		if(getCurrMap().getTileEntity(pointToMove) == target) {
			//System.out.println("attacking");
			entity.engage(target);
		}
		else {
			//System.out.println("pursuing");
			entity.setDirection(direction);
			getCurrMap().updateEntityLocation(entity, pointToMove);
		}
	}
}
