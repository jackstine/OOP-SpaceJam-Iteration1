package model;

import java.util.*;

import model.Entity.Avatar;
import model.Entity.Entity;
import utilities.Scaling;

public class GameMap {
	//TODO create a Generate Map function that the constructor calls
	private final int TILE_SCALE = Scaling.TILE_HEIGHT;
	private Tile[][] map;
	private HashMap<Entity,Location> entityToLocationMap;
//	private HashMap<Tile, Item> tileToItemMap;
	private int width;
	private int height;
	private Avatar avatar;
	
	private Map<String, Integer> keySet = new HashMap<String, Integer>(); //THIS NEEDS TO BE SAVED	

	public GameMap(){
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMap();
		this.setWidthHeight();
		entityToLocationMap=new HashMap<Entity,Location>();
		genDefaultKeys();
//		tileToItemMap = new HashMap<Tile,Item>();
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
	
	

	//MUST BE ACTIVATED AFTER THE MAP IS GENERATED
	private void setWidthHeight(){
		this.height = map.length * TILE_SCALE;
		this.width = map[0].length * TILE_SCALE;
	}
	
	public Tile getTile(Location location){
		int x=location.getX();
		int y=location.getY();
		return map[x][y];
	}

	public Tile getEntityTile(Entity entity){
		Location location= this.entityToLocationMap.get(entity);
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map[x][y];
	}
	
	public Point getMapLength(){
		return new Point(map.length,map[0].length);
	}
/*	public Tile getItemTile(Item item){
		//returns a tile;
		//item currently doesnot have a getLocation
		//needs to be added
		return map[x][y];
	} */
	
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}

	public Tile[][] tileSet(){    //returns two d array of the map tileset
		return map;
	}

	public void updateEntityLocation(Entity e, Location loc){
		System.out.println(e.getName() + " - (" + loc.getX() + ", " + loc.getY() + ")");
		entityToLocationMap.put(e,loc);	
	}
	
//	public void updateItemLocation(Tile t, Item i){
//		tileToItemMap.put(t, i);
//	}
	
	public Location getLocation(Entity e){
		return entityToLocationMap.get(e);
	}
	
	public void setAvatar(Avatar avatar){
		this.avatar=avatar;
	}
	
	public void setTile(Tile tile) {
		int x = tile.getLocation().getX();
		int y = tile.getLocation().getY();
		this.map[x][y] = tile;
	}
	
	public String toString() {
		String result = "";
		result += "Map:" + this.map.length + "," + this.map[0].length;
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[0].length; j++) {
				result += "\n" + this.map[i][j];
			}
		}
		result += "\n" + this.entityToLocationMap.keySet().size();
		for (Entity entity : this.entityToLocationMap.keySet()) {
			Location location = entityToLocationMap.get(entity);
			result += "\n" + entity.getName() + ":" + location.getX() + "," + location.getY();
		}
		for (String key : this.keySet.keySet()) result += "\n" + key + ":" + this.keySet.get(key);
		return result;
	}
}