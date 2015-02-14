package model;

import java.io.Serializable;

public class MP extends PrimaryStat implements Serializable {
	
	private Mana mana;
	
	public MP(int value) {
		super(value);
	}
	
	public void setMana(Mana mana) {
		this.mana = mana;
	}

	@Override
	protected boolean updateValue(int value) {
		if (value <= 0) return false; // zero mana
		this.value = Math.min(mana.getValue(), value);
		return true;
	}

}
