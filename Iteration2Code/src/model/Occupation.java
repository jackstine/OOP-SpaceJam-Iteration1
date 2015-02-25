package model;

import java.util.Map;

public abstract class Occupation{
	
	protected String portraitLocation;
	protected String name;
	
	public abstract void attack();
	public abstract void useAbiltiy();
	public abstract Map<String, Stat> createStats();
	
	public String getPortraitLocation() {
			return portraitLocation;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Occupation:" + this.name;
	}
}
