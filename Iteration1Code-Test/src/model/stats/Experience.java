package model.stats;


public class Experience extends PrimaryStat {

	public Experience(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		// CONSTRAINTS ON EXPERIENCE
		if (value < 0) return false;
		this.value = value;
		return true;
	}

}
