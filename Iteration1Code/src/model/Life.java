package model;

public class Life extends DerivedStat {

	private PrimaryStat hp;
	
	public Life(PrimaryStat hp) {
		super();
		this.hp = hp;
		((HP) hp).setLife(this);
	}
	
	@Override
	public void calculateValue() {
		// this value is based on hardiness and level
		int hardiness = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		// LIFE FORMULA
		this.value = hardiness * level;	
		this.hp.setValue(this.value);
	}
}
