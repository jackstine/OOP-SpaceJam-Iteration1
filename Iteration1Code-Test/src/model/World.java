package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.entity.Avatar;
import view.ControlField;

public class World {
	private Map<String, GameMap> maps = new HashMap<String, GameMap>();
	private Map<String, Integer> keySet = new HashMap<String, Integer>();
	
	
	public World(){
		maps.put("Main",new GameMap());
		maps.put("Cave", new GameMap(1));
		genDefaultKeys();
	}
	
	public World(GameMap Main){
		maps.put("Main",Main);
		maps.put("Cave", new GameMap(1));
		genDefaultKeys();
	}
	
	public World( Map<String, GameMap> maps, Map<String, Integer> keySet){
		this.maps = maps;
		this.keySet = keySet;
	}
	
	public GameMap getMap(String s){
		return maps.get(s);
	}
	
	public void setAvatar(Avatar avatar){
		for (Entry<String, GameMap> entry : maps.entrySet()) {
		    GameMap map = entry.getValue();
		    map.setAvatar(avatar);
		}
	}
	
	//Key Bind Functions
	/**
	 * Generates the default key set.
	 */
	public void genDefaultKeys(){
		keySet.put("SOUTHWEST",97);
		keySet.put("SOUTH",83);
		keySet.put("SOUTHEAST",99);
		keySet.put("EAST",68);
		keySet.put("NORTHEAST",105);
		keySet.put("NORTH",87);
		keySet.put("NORTHWEST",103);
		keySet.put("WEST",65);
		keySet.put("DANCE1",48);
		keySet.put("DANCE2",53);
	}
	
	public Map<String, Integer> getKeySet(){
		return keySet;
	}
	
	public void editKeySet(String s, int i){
		keySet.put(s,i);
	}
	
	public String toString(){
		String result = "WORLD:";
		result += maps.keySet().size();
		for (Entry<String, GameMap> entry : maps.entrySet()) {
		    String key = entry.getKey();
		    GameMap map = entry.getValue();
		    result = result +  "\n" + key;
		    result = result + "\n" +  map.toString();
		}
		for (String key : this.keySet.keySet()) result += "\n" + key + ":" + this.keySet.get(key);
		return result;
	}
}
