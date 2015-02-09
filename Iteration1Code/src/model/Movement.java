package model;

public class Movement extends PrimaryStat {

	public Movement(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		if (value < 0) return false;
		// check to see if value is possible
		return false;
	}

}
