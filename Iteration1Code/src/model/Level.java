package model;

import java.io.Serializable;

public class Level extends DerivedStat implements Serializable {

	public Level() {
		super();
	}
	
	public void update(int value) {
		this.setChanged();
		this.notifyObservers(this.value);		
	}
	
	public void addAllObservers(DerivedStat...derivedStats) {
		for (DerivedStat ds : derivedStats) {
			this.addObserver(ds);
			ds.addStat(this);
		}
	}
	
	@Override
	public void calculateValue() {
		// this value is based on experience
		int experience = this.stats.get(0).getValue();
		this.value = Math.min(20, (int) (Math.floor(25 + Math.sqrt(625 + 100 * experience)) / 50));	
		update(this.value);
	}
}
