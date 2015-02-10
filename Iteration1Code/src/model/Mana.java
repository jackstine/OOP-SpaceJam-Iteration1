package model;

public class Mana extends DerivedStat {
	
	public Mana() {
		super();
	}
	
	@Override
	public void calculateValue() {
		// this value is based on intellect and level
		int intellect = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		System.out.println("DER" + intellect + " HUR" + level);
		// MANA FORMULA
		this.value = intellect * level;
	}
}
