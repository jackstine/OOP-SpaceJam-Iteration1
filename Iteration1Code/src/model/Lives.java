package model;

public class Lives extends PrimaryStat {

	public Lives(int value) {
		super(value);
	}
	
	@Override
	protected boolean updateValue(int value) {
		// CONSTRAINTS ON LIVES
		if (value < 0 || value > 9) return false;
		this.value = value;
		return true;
	}

}
