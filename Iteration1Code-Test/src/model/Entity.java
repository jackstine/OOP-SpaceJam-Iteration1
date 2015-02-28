package model;

import java.util.Map;

import model.occupation.Occupation;
import model.slots.Equipment;

public abstract class Entity {
	protected Map<String,Stat> stats; 
	protected Occupation occupation;
	protected String name;
	protected int direction;
	protected Equipment equipment;
	
	// private GameMap map;
	// private Equipable equipment;
	
	// -------------------------------------------
	// Need to decide on what constructor we're using for Entity
	public Entity() {}
	
	public Entity(Occupation occupation) {
		this.occupation = occupation;
		this.stats = occupation.getStats();
		this.equipment = occupation.getEquipment();
	}
	// -------------------------------------------
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	public int getStatValue(String key) {
		if (this.stats.containsKey(key)) return this.stats.get(key).getValue();
		return -1;
	}
	
	public void setStatValue(String key, int value) {
		if (this.stats.containsKey(key)) this.stats.get(key).setValue(value);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Occupation getOccupation() {
		return occupation;
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
