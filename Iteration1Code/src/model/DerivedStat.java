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
	
	// every stat will override this method so it knows how
	// it is calculated with regards to the stats that it
	// is observing
	public abstract void calculateValue();
	
	// ONLY LEVEL WILL OVERRIDE THIS!!!!!!
	public void addAllObservers(DerivedStat...derivedStats) {}
	
	// add a stat to the list of stats being observed
	public void addStat(Stat stat) {
		this.stats.add(stat);
	}
	
	@Override
	// when notified of a change, recalculate the value
	public void update(Observable stat, Object value) {
		calculateValue();
	}
	
	public String toString(){
		return this.getClass().toString() + this.value;
	}
}
