package model;

import java.util.Observable;

public abstract class PrimaryStat extends Observable implements Stat {

	private int value;
	
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
	
	public abstract boolean updateValue(int value);
	
	public void addAllObservers(DerivedStat...derivedStats) {
		for (DerivedStat ds : derivedStats) {
			this.addObserver(ds);
			ds.addPrimaryStat(this);
		}
	}
}
