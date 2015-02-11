package model;
import java.util.Map;


public abstract class Entity {
	private Map<String,Stat> stats; 	
	private GameMap map;
	private Location location;
	private Equipable equipment;
	private Occupation occupation;
	
	private void attack() {
		//occupation.attack();
	}
	
	private void useAbility() {
		//occupation.useAbility();
	}
	
	public Location getLocation() {
		//query map for location

		return location;
	}
	
	public int getStatValue(String key) {
		if (stats.containsKey(key)) return stats.get(key).getValue();
		// the value doesn't exist, so we return -1
		return -1;
	}
	
	public void setStatValue(String key, int value) {
		if (stats.containsKey(key)) stats.get(key).setValue(value);
	}
}
