package model;

public class Lives extends PrimaryStat {

	public Lives(int value) {
		super(value);
	}
	
	@Override
	protected boolean updateValue(int value) {
		if (value < 0 || value > 10) return false;
		this.value = value;
		return true;
	}

}
