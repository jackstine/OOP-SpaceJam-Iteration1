package model;

import java.io.Serializable;

public class Experience extends PrimaryStat implements Serializable {

	public Experience(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		// CONSTRAINTS ON EXPERIENCE
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
