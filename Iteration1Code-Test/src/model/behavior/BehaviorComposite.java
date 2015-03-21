/*
 * Defines a big ol' list of behaviors. Use this if one isn't enough for your NPC you greedy sonnuva...
 */

package model.behavior;

import java.util.List;
import java.util.ArrayList;

import model.entity.Entity;

public class BehaviorComposite implements Behavior{
	private List<Behavior> behaviors;
	private Entity entity;
	
	public BehaviorComposite (Entity entity,Behavior... behaviors) {
		
		this.behaviors = new ArrayList<Behavior>();
		
		for(Behavior b : behaviors) {
			this.behaviors.add(b);
		}
	}

	public BehaviorIterator iterator () {
		return new BehaviorIterator(behaviors);
	}

	public void perform(Entity receiver) {
	}

	public void getBuffs() {
	}

	public void kill() {
	}
}
