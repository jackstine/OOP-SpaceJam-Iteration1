package model;

import model.slots.Equipment;

public class HunterStatFactory extends StatFactory {
//	public HunterStatFactory() {
//		
//	}
	
	public HunterStatFactory(Equipment equipment){
		super(equipment);
	}
	
	protected int getAgility() {
		return 20;
	}
	
	protected int getMovement() {
		return 20;
	}
}
