package model;

public class Level extends DerivedStat {

	public Level() {
		super();
	}
	
	public void update(int value) {
		calculateValue();
		System.out.println("UPDATING LEVEL!!!");
		this.setChanged();
		this.notifyObservers(this.value);		
	}
	
	public void addAllObservers(DerivedStat...derivedStats) {
		for (DerivedStat ds : derivedStats) {
			this.addObserver(ds);
			ds.addStat(this);
		}
	}
	
	@Override
	public void calculateValue() {
		// this value is based on experience
		int experience = this.stats.get(0).getValue();
		this.value = (int) (Math.floor(25 + Math.sqrt(625 + 100 * experience)) / 50);	
	}
}
