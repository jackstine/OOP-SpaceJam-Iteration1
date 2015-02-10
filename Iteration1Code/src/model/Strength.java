package model;

public class Strength extends PrimaryStat {

	public Strength(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		// CONSTRAINTS ON STRENGTH
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
