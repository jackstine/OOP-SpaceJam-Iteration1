package model;

import java.io.Serializable;

public class Movement extends PrimaryStat implements Serializable{

	public Movement(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		// CONSTRAINTS ON MOVEMENT
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
