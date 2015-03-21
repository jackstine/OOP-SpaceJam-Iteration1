package controller;

import java.util.ArrayList;

import model.GameMap;
import model.Location;
import model.Point;
import model.World;
import model.entity.Entity;
import utilities.Directions;

public class NPCMovementLoopController extends NPCMovementController{
	private ArrayList<String> movementLoop;
	
	public NPCMovementLoopController(Entity entity){
		//this.mapView = mapView;
		super(entity);
	}
	
	public void doArtificialIntelligence() {
		task = new CircleTask();
		System.out.println("STARTING");
		stopThread = false;
		task.start();
	}
	
	public void setMovementLoop(ArrayList<String> directives) {
		movementLoop = directives;
	}
	
	private class CircleTask extends Thread {
		//Entity entity = getNPC();
		GameMap map = getCurrMap();
		
		@Override
		public void run() {
			try {
				int instructionTrack = 0;
				while ((! interrupted()) && !stopThread) {
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
			} catch (Exception e) {
			}
			
			
		}
	}
}
