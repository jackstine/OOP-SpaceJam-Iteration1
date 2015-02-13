package model;
import java.util.Map;


public abstract class Entity {
	protected Map<String,Stat> stats; 
	protected Occupation occupation;
	// private GameMap map;
	private Location location;
	private Equipable equipment;
	
	public Entity() {
		
	}
	
	public Entity(Occupation occupation) {
		this.occupation = occupation;
		this.stats = occupation.createStats();
	}
	
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
		if (this.stats.containsKey(key)) return this.stats.get(key).getValue();
		return -1;
	}
	
	public void setStatValue(String key, int value) {
		if (this.stats.containsKey(key)) this.stats.get(key).setValue(value);
	}
}
