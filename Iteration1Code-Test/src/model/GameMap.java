package model;

import java.util.*;

import model.entity.Avatar;
import model.entity.Entity;
import utilities.Scaling;
import view.MapView;

public class GameMap extends Observable{
	//TODO create a Generate Map function that the constructor calls
	private final int TILE_SCALE = Scaling.TILE_HEIGHT;
	private MapSet map;
	private HashMap<Entity,Location> entityToLocationMap;
//	private HashMap<Tile, Item> tileToItemMap;
	private int width;
	private int height;
	private Avatar avatar;

	public GameMap () {
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMap();
		System.out.println("I WAS MADE WITHOUT A PARAMETER");
		entityToLocationMap = map.grabEntityLocations();
		System.out.println(entityToLocationMap);
		this.setWidthHeight();
//		tileToItemMap = new HashMap<Tile,Item>();
	}
	
	public GameMap(MapView mv){
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMap();
		this.setWidthHeight();
		addObserver(mv);
		entityToLocationMap=new HashMap<Entity,Location>();
//		tileToItemMap = new HashMap<Tile,Item>();
	}

	//MUST BE ACTIVATED AFTER THE MAP IS GENERATED
	private void setWidthHeight(){
		this.height = map.getHeight() * TILE_SCALE;
		this.width = map.getWidth() * TILE_SCALE;
	}
	
	public void setMapView(MapView mv) {
		addObserver(mv);
	}
	
	public Tile getTile(Point location){
		int x=location.getX();
		int y=location.getY();
		return map.getTile(x,y);
	}
	
	public Entity getTileEntity(Point point){
		return this.getTile(point).getEntity();
	}

	public Tile getEntityTile(Entity entity){
		System.out.println(entity);
		System.out.println(this.entityToLocationMap.get(entity)+"I AM PROBABLY THE LAST NULL");
		Location location= this.entityToLocationMap.get(entity);
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map.getTile(x,y);
	}
	
	public Location getEntityLocation(Entity entity){
		return this.entityToLocationMap.get(entity);
	}
	
	public HashMap<Entity,Location> getEntityToLocationMap() {
		return entityToLocationMap;
	}
	
	public Point getMapLength(){
		return new Point(map.getHeight(), map.getWidth());
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
		return map.getMap();
	}
	
	public boolean isPassable(Point pointOfTile){
		return this.getTile(pointOfTile).isPassable();
	}

	public void updateEntityLocation(Entity e, Location locationToUpdate){
		//keeps the invariant with the if condition
		if (this.isPassable(locationToUpdate)){
			Location locationOfEntity = this.getEntityLocation(e);	
			if (locationOfEntity != null){
				// I dont like this method at all, cause it is basically saying
				// get rid of this entity, even if it is not the entity I want
				this.getTile(locationOfEntity).dropEntity();
			}
			this.getTile(locationToUpdate).setEntity(e);
			entityToLocationMap.put(e,locationToUpdate);
			System.out.println("BAM BOOM BAM");
			this.setChanged();
			this.notifyObservers();
			this.setChanged();
		}
	}

//	public void updateItemLocation(Tile t, Item i){
//		tileToItemMap.put(t, i);
//	}
	
	public void notifyObservers()
	{
	    super.notifyObservers();
	    System.out.println("pls help");
	}
	
	public Location getLocation(Entity e){
		System.out.println(e+"in getLocation");
		System.out.println("HEYOOOO "+entityToLocationMap);
		Collection<Location> locations = entityToLocationMap.values();
		for(Location l : locations) {
			System.out.println(l);
		}
		System.out.println("found me at "+entityToLocationMap.get(e));
		return entityToLocationMap.get(e);
	}
	
	public void setAvatar(Avatar avatar){
		this.avatar=avatar;
	}
	
	public void setTile(Tile tile) {
		int x = tile.getLocation().getX();
		int y = tile.getLocation().getY();
		this.map.setTile(x,y,tile);
	}
	
	public String toString() {
		String result = "";
		result += "Map:" + this.map.getHeight() + "," + this.map.getWidth();
		for (int i = 0; i < this.map.getHeight(); i++) {
			for (int j = 0; j < this.map.getWidth(); j++) {
				result += "\n" + this.map.getTile(i,j);
			}
		}
		result += "\n" + this.entityToLocationMap.keySet().size();
		for (Entity entity : this.entityToLocationMap.keySet()) {
			Location location = entityToLocationMap.get(entity);
			result += "\n" + entity.getName() + ":" + location.getX() + "," + location.getY();
		}
		return result;
	}
}