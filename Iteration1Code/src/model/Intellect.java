package model;

public class Intellect extends PrimaryStat {

	public Intellect(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		// CONSTRAINTS ON INTELLECT
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
