package model;

public class Agility extends PrimaryStat {

	public Agility(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		if (value < 0) return false;
		// check to see if value is possible
		return false;
	}

}
