package model;

import java.util.*;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;
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
		entityToLocationMap = map.grabEntityLocations();
		this.setWidthHeight();
		this.setEntitiesLocations();
	}
	
	// used on load
	public GameMap(int width, int height) {
		this.map = new MapSet(new Tile[width][height]);
		this.entityToLocationMap = new HashMap<Entity, Location>();
	}
	
//	public GameMap(MapView mv){
//		MapBuilder m= new MapBuilder();
//		map = m.generateStructuredMap();
//		this.setWidthHeight();
//		addObserver(mv);
//		entityToLocationMap=new HashMap<Entity,Location>();
////		tileToItemMap = new HashMap<Tile,Item>();
//	}
	
	public GameMap(MapView mv){
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMap();
		this.setWidthHeight();
		addObserver(mv);
		entityToLocationMap=new HashMap<Entity,Location>();
//		tileToItemMap = new HashMap<Tile,Item>();
		this.setEntitiesLocations();
	}
	
	public GameMap(MapBuilder m) {
		map = m.generateStructuredMapv3();
		this.setWidthHeight();
		//addObserver(mv);
		entityToLocationMap=new HashMap<Entity,Location>();
		this.setEntitiesLocations();
	}
	
	public void setEntitiesLocations(){
		for (int i = 0; i < this.map.getMap().length; i++)
			for (int j = 0; j < this.map.getMap()[i].length; j++)
				if (this.map.getMap()[i][j].hasEntity()){
					this.map.getMap()[i][j].getLocation();
					this.entityToLocationMap.put(this.map.getMap()[i][j].getEntity(), new Location(i,j));
				}
	}
	
	public HashMap<Entity, Location> getEntityToLocationMap() {
		return entityToLocationMap;
	}
	
	
	public void kill(Location loc){
		Entity entity = this.getTile(loc).dropEntity();
		this.entityToLocationMap.remove(entity);
		entity.makeDeathSoundEffect();
		System.out.println(entity +" was killed");
		entity.kill();
		this.send();
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
		Location location= this.entityToLocationMap.get(entity);
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map.getTile(x,y);
	}
	
	public Location getEntityLocation(Entity entity){
		return this.entityToLocationMap.get(entity);
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
			this.send();
		}
	}
	
	public void send(){
		this.setChanged();
		this.notifyObservers();
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

	public Set<Entity> getEntities() {
		return this.entityToLocationMap.keySet();
	}
}