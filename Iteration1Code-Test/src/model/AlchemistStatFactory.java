package model;

import model.slots.Equipment;


public class AlchemistStatFactory extends StatFactory{
//	public AlchemistStatFactory(){}\
	
	public AlchemistStatFactory(Equipment equipment){
		super(equipment);
	}
	
	protected int getIntellect() {
		return 20;
	}
	
	protected int getMovement() {
		return 15;
	}
}
