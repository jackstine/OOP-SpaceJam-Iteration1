package model;

import java.io.Serializable;

public class TerminatorStatFactory extends StatFactory implements Serializable{
	public TerminatorStatFactory() {
		
	}
	
	protected int getStrength() {
		return 20;
	}
	
	protected int getHardiness() {
		return 20;
	}
}
