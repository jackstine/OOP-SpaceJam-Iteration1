package model;

import model.slots.Equipment;


public class TerminatorStatFactory extends StatFactory{
//	public TerminatorStatFactory() {}
	
	public TerminatorStatFactory(Equipment equipment){
		super(equipment);
	}
	
	protected int getStrength() {
		return 20;
	}
	
	protected int getHardiness() {
		return 20;
	}
}
