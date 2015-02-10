package model;

import java.util.*;
import java.util.Observable;
import java.util.Observer;

public abstract class DerivedStat extends Observable implements Stat, Observer {

	protected List<Stat> stats;
	protected int value;
	
	public DerivedStat() {
		this.stats = new ArrayList<Stat>();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public abstract void calculateValue();
	
	// ONLY LEVEL WILL OVERRIDE THIS!!!!!!
	public void addAllObservers(DerivedStat...derivedStats) {}
	
	public void addStat(Stat stat) {
		this.stats.add(stat);
	}
	
	@Override
	public void update(Observable stat, Object value) {
		calculateValue();
	}
	
	public String toString(){
		return ""+this.value;
	}
}
