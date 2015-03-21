package controller;

import java.util.ArrayList;

import utilities.Directions;
import view.MapView;
import model.entity.*;
import model.GameMap;
import model.Location;
import model.Point;
import model.QuestHandler;
import model.Tile;
import model.World;

public abstract class NPCMovementController extends MovementController {

	protected Entity entity;
	protected boolean stopThread = false;
	protected Thread task;
	
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
	
	public abstract void doArtificialIntelligence();
	
	public void interrupt(){
		try{
			System.out.println("stopped");
			this.task.interrupt();
			stopThread = true;
		}catch(Exception e){}
	}

	public void move(Point step, int direction) {	
		System.out.println("a");
		Location pointToMove = new Location(this.getEntityLocation());
		System.out.println("b");
		pointToMove.addLocation(step);
		System.out.println("c");
		entity.setDirection(direction);
		System.out.println("d");
		getCurrMap().updateEntityLocation(entity, pointToMove);
		System.out.println("e");
	}

	
}
