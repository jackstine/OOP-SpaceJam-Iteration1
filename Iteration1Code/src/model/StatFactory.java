package model;

import java.util.HashMap;
import java.util.Map;

public abstract class StatFactory {
	
	private Map<String,Stat> map;
	
	public StatFactory() {
		
	}
	
	public final Map<String, Stat> initializeStats() {
		map = createMap();
		createStats();
		return map;
	}
	
	protected Map<String, Stat> createMap() {
		map = new HashMap<String, Stat>();
	}
	
	protected void createStats() {
		
	}
	
	protected int getLivesLeft() {
		
	}
	
	protected int getStrength() {
		
	}
	
	protected int getAgility() {
		
	}
	
	protected int getIntellect() {
		
	}
	
	protected int getHardiness() {
		
	}
	
	protected int getExperience() {
		
	}
	
	protected int getMovement() {
		
	}
	
	
	
}
