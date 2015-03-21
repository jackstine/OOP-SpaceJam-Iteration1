package model.stats.factory;

import model.slots.Equipment;

public class OrcTerminatorFactory extends StatFactory{

	public OrcTerminatorFactory(Equipment equipment) {
		super(equipment);
	}
	
	protected int getLivesLeft() {
		return 1;
	}
	
	protected int getStrength() {
		return 2;
	}
	
	protected int getAgility() {
		return 4;
	}
	
	protected int getIntellect() {
		return 10;
	}
	
	protected int getHardiness() {
		return 50;
	}
	
	protected int getExperience() {
		return 0;
	}
	
	protected int getMovement() {
		return 10;
	}

}
