package model.stats.factory;

import model.slots.Equipment;

public class AlchemistStatFactory extends StatFactory{
	
	public AlchemistStatFactory(Equipment equipment){
		super(equipment);
	}
	
	protected int getIntellect() {
		return 20;
	}
}
