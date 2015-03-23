package model.behavior;

import java.util.ArrayList;

public class BehaviorIterator {
	private ArrayList<Behavior> behaviors;
	private int size;
	private int index = 0;
	
	public BehaviorIterator (ArrayList<Behavior> target) {
		behaviors = target;
		size = behaviors.size();
	}
	
	public void next () {
		index = ((index+1) % size);
	}
	
	public Behavior get () {
		return behaviors.get(index);
	}
	
	public void reset () {
		index = 0;
	}
}
