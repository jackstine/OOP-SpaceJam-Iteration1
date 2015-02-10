package model;

import java.util.Observable;

public abstract class PrimaryStat extends Observable implements Stat {

	protected int value;
	
	public PrimaryStat(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	// this method is called when we want to update the value
	// of a stat; if we do change the value, then we must
	// notify all Observers that the value has changed
	public void update(int value) {
		// check if we can update the value
		boolean updateResult = updateValue(value);
		if (updateResult) {
			// say that the stat has changed, and notify the Observers
			this.setChanged();
			this.notifyObservers(value);
		}		
	}
	
	// every stat must override this in order to set constraints
	protected abstract boolean updateValue(int value);
	
	// for each DerivedStat, add them as an Observer, and then
	// the DerivedStats will add this to its list of stats
	public void addAllObservers(DerivedStat...derivedStats) {
		for (DerivedStat ds : derivedStats) {
			this.addObserver(ds);
			ds.addStat(this);
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.getClass().getName() + " ");
		s.append(this.getValue());
		
		return s.toString();
	}
}
