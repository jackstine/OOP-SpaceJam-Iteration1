package controller;

import model.GameMap;
import model.NPC;

public abstract class AIController {
	private NPC npc;
	private Thread task;	//task being null implies the AI thread has not began
	private GameMap map;
	
	public AIController(NPC npc, GameMap map) {
		this.npc = npc;
		this.map = map;
		
	}
	
	protected abstract void doArtificialIntelligence();
	//THIS METHOD WILL BE USED TO INSTANTIATE A CONCRETE AI OBJECT AND BEGIN ITS EXECUTION THREAD
	//BY PASSING ITS CREATED THREAD OBJECT TO AIController's doTask() METHOD
	
	protected final NPC getNPC() {
		return npc;
	}
	
	protected final GameMap getMap() {
		return map;
	}
	
	protected final void doTask(Thread task) {
		this.task = task;
		task.start();
	}
}
