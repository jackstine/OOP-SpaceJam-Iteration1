package model;
import java.util.Map;


public abstract class Entity {
	protected Map<String,Stat> stats; 
	protected Occupation occupation;
	// private GameMap map;
	private Location location;
	private Equipable equipment;
	
	// -------------------------------------------
	// Need to decide on what constructor we're using for Entity
	public Entity() {}
	
	public Entity(Occupation occupation) {
		this.occupation = occupation;
		this.stats = occupation.createStats();
	}
	// -------------------------------------------
	
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
	
	// -------------------------------------------
	// not 1st iteration stuff
	private void attack() {
		//occupation.attack();
	}
	
	private void useAbility() {
		//occupation.useAbility();
	}
	// -------------------------------------------
}
