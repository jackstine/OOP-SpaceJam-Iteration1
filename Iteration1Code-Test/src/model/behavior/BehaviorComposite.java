/*
 * Defines a big ol' list of behaviors. Use this if one isn't enough for your NPC you greedy sonnuva...
 */

package model.behavior;

import java.util.List;
import java.util.ArrayList;

import model.entity.Entity;

public class BehaviorComposite implements Behavior{
	private ArrayList<Behavior> behaviors;
	private int state;
	
	//passive = 0;
	//active = 1;
	
	public BehaviorComposite (Behavior... behaviors) {
		
		this.behaviors = new ArrayList<Behavior>();
		
		for(Behavior b : behaviors) {
			this.behaviors.add(b);
		}
		
		state = 0;
	}

	public BehaviorIterator iterator () {
		return new BehaviorIterator(behaviors);
	}

	public void trigger () {
		if(behaviors.size() == 2) {
			state = 1;
		}
	}
	
	public void reset () {
		state = 0;
	}
	
	public boolean isTriggered () {
		return state == 1;
	}
	
	public void perform(Entity receiver) {
		//System.out.println("performing "+behaviors.get(state));
		behaviors.get(state).perform(receiver);
	}

	public void getBuffs() {
	}

	public Behavior getBehavior () {
		return behaviors.get(state);
	}
	
	public void kill() {
		behaviors.get(state).kill();
	}
	
	public String toString() {
		return "IT IS I, THE COMPOSITE";
	}
}