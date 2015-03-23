package model.stats.factory;

import model.slots.Equipment;

public class BossStatFactory extends StatFactory{

	public BossStatFactory(Equipment equipment) {
		super(equipment);
	}
	
	protected int getLivesLeft() {
		return 1;
	}
	
	protected int getStrength() {
		return 50;
	}
	
	protected int getAgility() {
		return 7;
	}
	
	protected int getIntellect() {
		return 30;
	}
	
	protected int getHardiness() {
		return 100;
	}
	
	protected int getExperience() {
		return 0;
	}
	
	protected int getMovement() {
		return 50;
	}
	
	protected int getSight() {
		return 6;
	}

}
