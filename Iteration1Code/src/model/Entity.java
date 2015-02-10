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
<<<<<<< HEAD
		return location;
	}
	
	public int getLife() {
		int result = 0;
		try {
			Stat s = stats.get("Life");
			result = s.getValue();
		}
		catch(NullPointerException e) {
			System.out.println("You don't even exist");
		}
		return result;
=======
		return location; // this is just to shut up Eclipse
>>>>>>> 3fc24dbe374948c8a2aac1facae43b046d2a5a21
	}
}
