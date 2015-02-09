package model;

import java.util.Observable;

public abstract class PrimaryStat extends Observable implements Stat {

	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	public abstract boolean updateValue(int value);
	
}
