package model;
import java.util.Map;


public abstract class Entity {
	private Map<String,Stat> stats; 	
	private GameMap map;
	private Location location;
	private Equipment equipment;
	private Occupation occupation;
	
	private void attack() {
		//occupation.attack();
	}
	
	private void useAbility() {
		//occupation.useAbility();
	}
	
	public Location getLocation() {
		//query map for location
		return new Location();
	}
}
