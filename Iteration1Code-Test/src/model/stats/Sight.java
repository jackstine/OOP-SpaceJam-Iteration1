package model.stats;

public class Sight extends PrimaryStat {

	public Sight(int value) {
		super(value);
	}

	@Override
	protected boolean updateValue(int value) {
		// CONSTRAINTS ON SIGHT
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
