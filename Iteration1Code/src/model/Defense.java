package model;

import java.util.Observable;
import java.util.Observer;

public class Defense extends PrimaryStat implements Observer{

	public Defense(int value) {
		super(value);
	}

	@Override
	public boolean updateValue(int value) {
		if (value < 0) return false;
		
		return false;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.updateValue(arg);
		
	}
}
