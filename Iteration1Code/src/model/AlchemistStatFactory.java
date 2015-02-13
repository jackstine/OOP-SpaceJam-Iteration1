package model;

import java.io.Serializable;

public class AlchemistStatFactory extends StatFactory implements Serializable{
	public AlchemistStatFactory() {
		
	}
	
	protected int getIntellect() {
		return 20;
	}
	
	protected int getMovement() {
		return 15;
	}
}
