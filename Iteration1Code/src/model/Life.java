package model;

public class Life extends DerivedStat {
	private int hp;
	
	public Life() {
		super();
		this.hp = 0;
	}
	
	public void setValue(int value) {
		this.hp = value;	
	}
	
	@Override
	public void calculateValue() {
		// this value is based on hardiness and level
		int hardiness = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		// LIFE FORMULA
		this.value = hardiness * level;	
		// set the HP to max HP 
		this.hp = this.value;
	}
	
	
}
