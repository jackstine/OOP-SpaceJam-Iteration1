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
		int result = 0;
		try {
			result = stats.get(key).getValue();
		}
		catch(NullPointerException e) {
			System.out.println("You don't even exist");
		}
		return result;
	}
	
	public void setStatValue(String key, int value) {
		try {
			stats.get(key).setValue(value);
		} catch (Exception e) {
			
		}
	}
}
