package model;

public class Hardiness extends PrimaryStat {

	public Hardiness(int value) {
		super(value);
	}

	@Override
	protected boolean updateValue(int value) {
		if (value < 0 || value > 100) return false;
		this.value = value;
		return true;
	}

}
