package model;

public class Life extends DerivedStat {

	public Life() {
		super();
	}
	
	@Override
	public void calculateValue() {
		// this value is based on hardiness and level
		int hardiness = this.stats.get(0).getValue();
		//int level = this.stats.get(0).getValue();
		this.value = hardiness;		
	}
}
