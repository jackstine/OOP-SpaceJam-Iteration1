package model;

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class GameMap{
	private Tile[][] map;
	MapBuilder m;
	//private HashMap<Entity,Location> entityToLocationMap;
	//private HashMap<Item,Location> itemToLocationMap;


	public GameMap(){
		m= new MapBuilder();
		map = m.tileSet();
		//entityToLocationMap=new HashMap<Entity,Location>();
	}

	public Tile getTile(Location location){
		int x=(int)location.getX();
		int y=(int)location.getY();
		return map[x][y];
	}

	//public Tile getEntityTile(Entity entity){
	//	Location location= entity.getLocation();
		//int x=(int)location.getX();
		//int y=(int)location.getY();
		//return map[x][y];
	//}
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

	public void updateEntityLocation(){
		
	}

	public void draw(Graphics g){
		for(int i=0;i<35;i++){
			for(int j=0;j<35;j++){
				//player.draw(g);
				map[i][j].draw(g);
			}
		}
	}
}