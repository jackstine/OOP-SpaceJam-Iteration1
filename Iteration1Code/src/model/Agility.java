package model;

import java.io.Serializable;

public class Agility extends PrimaryStat implements Serializable {

	public Agility(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		// CONSTRAINTS ON AGILITY
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
