package controller;

import java.util.ArrayList;

import model.GameMap;
import model.Location;
import model.Point;
import model.RadialInfluenceSet;
import model.World;
import model.behavior.RadialEntitySight;
import model.entity.Entity;
import model.entity.NPC;
import utilities.Directions;

public class NPCMovementLoopController extends NPCMovementController{
	private ArrayList<String> movementLoop;
	
	public NPCMovementLoopController(Entity entity){
		super(entity);
	}
	
	public void doArtificialIntelligence() {
		task = new CircleTask();
		stopThread = false;
		task.start();
	}
	
	public void setMovementLoop(ArrayList<String> directives) {
		movementLoop = directives;
	}
	
	private class CircleTask extends Thread {
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				int instructionTrack = 0;
				while (!stopThread) {
						if(movementLoop.get(instructionTrack%movementLoop.size()).equals("forward")) {
							move(Directions.getPoint(entity.getDirection()),entity.getDirection());
						}
						else if(movementLoop.get(instructionTrack%movementLoop.size()).equals("clockwise")) {
							entity.setDirection(Directions.getClockwiseRotation(entity.getDirection()));
							move(Directions.getPoint(entity.getDirection()),entity.getDirection());
						}
						instructionTrack++;
					try{
						sleep(10000/entity.getStats().getStatValue("Movement"));
					}catch(Exception e){}
				}
			} 
			catch (Exception e) {
			}
		}
	}
}
