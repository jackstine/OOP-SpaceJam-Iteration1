package model;

import java.io.Serializable;

public class HunterStatFactory extends StatFactory implements Serializable{
	public HunterStatFactory() {
		
	}
	
	protected int getAgility() {
		return 20;
	}
	
	protected int getMovement() {
		return 20;
	}
}
