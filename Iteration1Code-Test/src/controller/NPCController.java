package controller;

import model.GameMap;
import model.Location;
import model.World;
import model.entity.*;

public abstract class NPCController {

	protected Entity entity;
	protected boolean stopThread = false;
	protected Thread task;
	
	public NPCController(Entity entity){
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
			stopThread = true;
		}catch(Exception e){}
	}
}
