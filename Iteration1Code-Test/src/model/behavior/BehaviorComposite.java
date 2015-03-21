/*
 * Defines a big ol' list of behaviors. Use this if one isn't enough for your NPC you greedy sonnuva...
 */

package model.behavior;

import java.util.List;
import java.util.ArrayList;

public class BehaviorComposite {
	private List<Behavior> behaviors;
	
	public BehaviorComposite (Behavior... behaviors) {
		
		this.behaviors = new ArrayList<Behavior>();
		
		for(Behavior b : behaviors) {
			this.behaviors.add(b);
		}
	}

	public BehaviorIterator iterator () {
		return new BehaviorIterator(behaviors);
	}
}
