package model;

public class DefensiveRating extends DerivedStat {

	public DefensiveRating() {
		super();
	}
	
	@Override
	public void calculateValue() {
		// this value is based on agility and level
		int agility = this.stats.get(0).getValue();
		int level = this.stats.get(1).getValue();
		// DEFENSIVE RATING FORMULA
		this.value = agility * level;		
	}
}
