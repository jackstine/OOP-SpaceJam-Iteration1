package model.behavior;

import java.util.Stack;

import model.behavior.Behavior;
import model.entity.Entity;

public class State {
	private Stack<Behavior> states;
	
	public State(){
		this.states = new Stack<Behavior>();
	}
	
	public State(Behavior behavior){
		this();
		this.setState(behavior);
	}
	
	public void perform(Entity receiver){
		this.states.peek().perform(receiver);
	}
	
	public void setState(Behavior behavior){
		this.states.push(behavior);
	}
	
	public void pop(){
		//TODO test time constraints so that we can keep the invariant of the states
		this.states.pop();
	}
	
	public void kill(){
		while( ! this.states.empty()){
			states.peek().kill();
			states.pop();
		}
	}

}
