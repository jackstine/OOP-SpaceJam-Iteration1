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
		map.put("Lives", new Lives(getLivesLeft()));
		map.put("Strength", new Strength(getStrength()));
		map.put("Agility", new Agility(getAgility()));
		map.put("Intellect", new Intellect(getIntellect()));
		map.put("Hardiness", new Hardiness(getHardiness()));
		map.put("Experience", new Experience(getExperience()));
		map.put("Movement", new Movement(getMovement()));
	}
	
	protected int getLivesLeft() {
		return 3;
	}
	
	protected int getStrength() {
		return 10;
	}
	
	protected int getAgility() {
		return 10;
	}
	
	protected int getIntellect() {
		return 10;
	}
	
	protected int getHardiness() {
		return 10;
	}
	
	protected int getExperience() {
		return 0;
	}
	
	protected int getMovement() {
		return 10;
	}
	
}
