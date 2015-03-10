package model;

import java.util.HashMap;
import java.util.Map;

public class World {
	private Map<String, GameMap> maps = new HashMap<String, GameMap>();
	
	public World(GameMap main, GameMap cave){
		maps.put("Main", main);
		maps.put("Cave", cave);
	}
	
	public GameMap getMap(String s){
		return maps.get(s);
	}
}
