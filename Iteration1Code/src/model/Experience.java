package model;

public class Experience extends PrimaryStat {

	public Experience(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		if (value < 0 || value > 10000) return false;
		this.value = value;
		return true;
	}

}
