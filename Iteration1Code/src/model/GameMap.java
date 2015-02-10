package model;
import java.util.*;

public class GameMap{
	private Tile[][] map;
	private HashMap<Entity,Location> entityToLocationMap;
	private HashMap<Item,Location> itemToLocationMap;


	public GameMap(){

	}

	public Tile getTile(Location location){
		//returns tile;
	}

	public Tile getEntityTile(Entity entity){
		//returns a tile;
	}
	public Item getItemTile(Item item){
		//returns a tile;
	}
}