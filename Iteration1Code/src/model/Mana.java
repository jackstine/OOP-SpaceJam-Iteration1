package model;

import java.io.Serializable;

public class Mana extends DerivedStat implements Serializable {
	
	public Mana() {
		super();
	}
	
	@Override
	public void calculateValue() {
		// this value is based on intellect and level
		int intellect = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		// MANA FORMULA
		this.value = intellect * level;
	}
}
