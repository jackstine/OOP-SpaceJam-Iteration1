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
	
	public void update(int value) {
		boolean updateResult = updateValue(value);
		if (updateResult) {
			this.setChanged();
			this.notifyObservers(value);
		}		
	}
	
	protected abstract boolean updateValue(int value);
	
	public void addAllObservers(DerivedStat...derivedStats) {
		for (DerivedStat ds : derivedStats) {
			this.addObserver(ds);
			ds.addStat(this);
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.getClass().getName());
		s.append(this.getValue());
		
		return s.toString();
	}
}
