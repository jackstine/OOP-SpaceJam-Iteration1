package model.stats;




public class Mana extends DerivedStat {
	
	private PrimaryStat mp;
	
	public Mana(PrimaryStat mp) {
		super();
		this.mp = mp;
		((MP) mp).setMana(this);
	}
	
	@Override
	public void calculateValue() {
		// this value is based on intellect and level
		int intellect = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		// MANA FORMULA
		this.value = intellect * level;
		this.mp.setValue(this.value);
	}
}
