package model;
import java.util.*;

public class GameMap{
	private Tile[][] map;
	//private HashMap<Entity,Location> entityToLocationMap;
	//private HashMap<Item,Location> itemToLocationMap;


	public GameMap(){
		map = new Tile[3][3];  //just a test
								//i think itll be easier to hardcode the map here
								//than to create a new mapBuilder class
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				map[j][i]=new Tile(new DesertTerrain(),i,j);
				if(i==2 && j==2){
					map[j][i].setTerrain(new RadioactiveWasteTerrain());
				}
			}
		}
	}

	public Tile getTile(Location location){
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map[x][y];
	}

	public Tile getEntityTile(Entity entity){
		Location location= entity.getLocation();
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map[x][y];
	}
	/*
	public Tile getItemTile(Item item){
		//returns a tile;
		//item currently doesnot have a getLocation
		//needs to be added
	}
	*/

	public Tile[][] tileSet(){    //returns two d array of the map tileset
		return map;
	}
}