package model;



public class Hardiness extends PrimaryStat {

	public Hardiness(int value) {
		super(value);
	}

	@Override
	protected boolean updateValue(int value) {
		// CONSTRAINTS ON HARDINESS
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
