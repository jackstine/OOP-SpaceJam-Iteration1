package model;

public class Hardiness extends PrimaryStat {

	public Hardiness(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		if (value < 0) return false;
		// check to see if value is possible
		return false;
	}

}
