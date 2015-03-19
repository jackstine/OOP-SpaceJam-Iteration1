package model.behavior;

import java.util.Stack;

import model.behavior.Behavior;
import model.entity.Entity;

public class State {
	private Stack<Behavior> states;
	
	public State(Behavior behavior){
		this.states = new Stack<Behavior>();
		this.states.push(behavior);
	}
	
	public void perform(Entity entity){
		this.states.peek().perform(entity);;
	}
	
	public void setState(Behavior behavior){
		this.states.push(behavior);
	}
	
	public void pop(){
		//TODO test time constraints so that we can keep the invariant of the states
		this.states.pop();
	}

}
