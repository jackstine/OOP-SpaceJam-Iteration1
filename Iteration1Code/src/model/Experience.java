package model;

public class Experience extends PrimaryStat {

	public Experience(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		if (value < 0) return false;
		// check to see if value is possible
		return false;
	}

}
