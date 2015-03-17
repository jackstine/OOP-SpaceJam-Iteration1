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

	public GameMap(){
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMap();
		this.setWidthHeight();
		entityToLocationMap=new HashMap<Entity,Location>();
//		tileToItemMap = new HashMap<Tile,Item>();
	}
	
	public GameMap(int state){
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMapv3();
		this.setWidthHeight();
		entityToLocationMap=new HashMap<Entity,Location>();
	}	

	//MUST BE ACTIVATED AFTER THE MAP IS GENERATED
	private void setWidthHeight(){
		this.height = map.length * TILE_SCALE;
		this.width = map[0].length * TILE_SCALE;
	}
	
	public Tile getTile(Point location){
		int x=location.getX();
		int y=location.getY();
		return map[x][y];
	}
	
	public Entity getTileEntity(Point point){
		return this.getTile(point).getNPC();
	}

	public Tile getEntityTile(Entity entity){
		Location location= this.entityToLocationMap.get(entity);
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map[x][y];
	}
	
	public Location getEntityLocation(Entity entity){
		return this.entityToLocationMap.get(entity);
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
	
	public boolean isPassable(Point pointOfTile){
		return this.getTile(pointOfTile).isPassable();
	}

	public void updateEntityLocation(Entity e, Location locationToUpdate){
		//TODO this method is very bug prone, it needs to be changed and split to other methods
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(e.getName() + " - (" + locationToUpdate.getX() + ", " + locationToUpdate.getY() + ")");
		//FROM
		Location locationOfEntity = this.getEntityLocation(e);
		//Move, DROP
		if (locationOfEntity != null){
			System.out.println("This is the location of the entity" + locationOfEntity);
			this.getTile(locationOfEntity).dropEntity();
		}
		//MOVE TO
		this.getTile(locationToUpdate).setNPC(e);
		entityToLocationMap.put(e,locationToUpdate);
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
		return result;
	}
}