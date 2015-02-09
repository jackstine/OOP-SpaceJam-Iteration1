package model;

import java.util.List;
import java.util.Observer;

public abstract class DerivedStat implements Stat, Observer {

	private List<PrimaryStat> primaryStats;
	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	public abstract void calculateValue();
	
	public void update(PrimaryStat primaryStat, int value) {
		calculateValue();
	}
}
