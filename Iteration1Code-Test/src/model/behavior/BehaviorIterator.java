package model.behavior;

import java.util.List;

public class BehaviorIterator {
	private List<Behavior> behaviors;
	private int size;
	private int index = 0;
	
	public BehaviorIterator (List<Behavior> target) {
		behaviors = target;
		size = behaviors.size();
	}
	
	public Behavior next () {
		if( hasNext() ) {
			return behaviors.get(index++);
		}
		return null;
	}
	
	public void reset () {
		index = 0;
	}
	
	public boolean hasNext () {
		return index < (size - 1);
	}
}
