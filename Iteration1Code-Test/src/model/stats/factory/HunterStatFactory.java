package model.stats.factory;

import model.slots.Equipment;

public class HunterStatFactory extends StatFactory {
	
	public HunterStatFactory(Equipment equipment){
		super(equipment);
	}
	
	protected int getAgility() {
		return 20;
	}
}
