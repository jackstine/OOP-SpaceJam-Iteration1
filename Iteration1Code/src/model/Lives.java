package model;

import java.io.Serializable;

public class Lives extends PrimaryStat implements Serializable{

	public Lives(int value) {
		super(value);
	}
	
	@Override
	protected boolean updateValue(int value) {
		// CONSTRAINTS ON LIVES
		if (value < 0 || value > 9) return false;
		this.value = value;
		return true;
	}

}
