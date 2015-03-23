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
		this.setState(behavior);
	}
	
	public void perform(Entity receiver){
		this.states.peek().perform(receiver);
	}
	
	public void setState(Behavior behavior){
		this.states.push(behavior);
	}
	
	public Behavior getState () {
		return this.states.peek();
	}
	
	public void pop(){
		//TODO test time constraints so that we can keep the invariant of the states
		this.states.pop();
	}
	
	public void revert(){
		// since you cannot get rid of the entities original behavior/function
		// it will always keep the original behavior
		if ( states.size() > 1 ){
			states.peek().kill();
			states.pop();
		}
	}
	
	public void kill(){
		while( ! this.states.empty()){
				states.peek().kill();
				states.pop();
		}
	}
}	
	
	

/*package model.behavior;

import java.util.ArrayList;
import java.util.Stack;

import model.behavior.Behavior;
import model.entity.Entity;

public class State {
	private ArrayList<Behavior> states;
	private BehaviorIterator iter;
	
	public State(){
		this.states = new ArrayList<Behavior>();
		iter = new BehaviorIterator(states);
	}
	
	public State(Behavior... behavior){		
		this.states = new ArrayList<Behavior>();
		for(Behavior b : behavior) {
			this.states.add(b);
		}
	}
	
	public void perform(Entity receiver){
		System.out.println("PERFORMING" +iter.get());
		this.iter.get().perform(receiver);
	}
	
	public void setState(Behavior...  behavior){
		this.states = new ArrayList<Behavior>();
		for(Behavior b : behavior) {
			this.states.add(b);
		}
		iter = new BehaviorIterator(states);
	}

	public void advanceState() {
		this.iter.next();
	}
	
	public void kill() {
		this.iter.get().kill();
	}
	
	/*public void pop(){
		//TODO test time constraints so that we can keep the invariant of the states
		this.states.pop();
	}
	
	public void revert(){
		if (! this.states.empty()){
=======
>>>>>>> 03363acf2b4f8778bc0e99b7e3fa5ca9044c9346
			states.peek().kill();
			states.pop();
		}
	}
	
	public void kill(){
		while( ! this.states.empty()){
			states.peek().kill();
			states.pop();
		}
	}

}*/
