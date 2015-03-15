package controller;

import model.GameMap;
import model.Location;
import model.Point;
import model.Entity.NPC;

public abstract class AIController {
	private NPC npc;
	private Thread task;	//task being null implies the AI thread has not began
	private GameMap map;
	protected Location npcLocation;
	protected Location temp;
	
	
	
	public AIController(NPC npc, GameMap map) {
		this.npc = npc;
		this.map = map;
		this.npcLocation = map.getLocation(npc);
	}
	
	protected abstract void doArtificialIntelligence();
	//THIS METHOD WILL BE USED TO INSTANTIATE A CONCRETE AI OBJECT AND BEGIN ITS EXECUTION THREAD
	//BY PASSING ITS CREATED THREAD OBJECT TO AIController's doTask() METHOD
	
	protected final NPC getNPC() {
		return npc;
	}
	
	public void move(Point point, int direction){
		npc.setDirection(direction);
		if(map.getTile(temp.addLocation(point)).isPassable()){
			npcLocation.add(point);		
		}
		else{
//			temp.add(point);
			System.out.println(temp + "   this is the temp location");
			System.out.println(npcLocation + "   this is the avtar");
			//System.out.println(map.getTile(temp).getNPC());
		}
		System.out.println(map.getTile(npcLocation).getTerrain());	
	}
	
	protected final GameMap getMap() {
		return map;
	}
	
	protected final void doTask(Thread task) {
		this.task = task;
		task.start();
	}
}

