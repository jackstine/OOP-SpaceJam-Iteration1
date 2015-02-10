package model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class DerivedStat implements Stat, Observer {

	protected List<PrimaryStat> primaryStats;
	protected int value;
	
	public int getValue() {
		return this.value;
	}
	
	public abstract void calculateValue();
	
	public void addPrimaryStat(PrimaryStat primaryStat) {
		primaryStats.add(primaryStat);
	}
	
	@Override
	public void update(Observable primaryStat, Object value) {
		calculateValue();
	}
	
	public String toString(){
		return ""+this.value;
	}
}
