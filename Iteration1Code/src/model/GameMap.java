package model;

import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

import utilities.Scaling;
import view.InventoryView;

public class GameMap {
	//TODO create a Generate Map function that the constructor calls
	private final int TILE_SCALE = Scaling.TILE_HEIGHT;
	private Tile[][] map;
	private HashMap<Entity,Location> entityToLocationMap;
	private final int RANGE=3;
	private int width;
	private int height;
	private int deltaX;
	private int deltaY;
	private Avatar avatar;


	public GameMap(){
		MapBuilder m= new MapBuilder();
		map = m.generateStructuredMap();
		this.setWidthHeight();
		entityToLocationMap=new HashMap<Entity,Location>();
		deltaX=0;
		deltaY=0;
	}
	
	// I put a item in it, it will generate the Item GameMap
	//TODO this is just for practicing
	/*public GameMap(Item item){
		// just set it to a random number size
		MapBuilder m= new MapBuilder(10,10);
		map = m.generateMapWithItems();
		this.setWidthHeight();
		entityToLocationMap = new HashMap<Entity,Location>();
		items = m.getItems();
		test=0;
	}
	*/

	//MUST BE ACTIVATED AFTER THE MAP IS GENERATED
	private void setWidthHeight(){
		this.height = map.length * TILE_SCALE;
		this.width = map[0].length * TILE_SCALE;
	}
	
	public Point getMapLength(){
		return new Point(map.length, map[0].length);
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
	/*
	public Tile getItemTile(Item item){
		//returns a tile;
		//item currently doesnot have a getLocation
		//needs to be added
	}
	*/
	
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
		entityToLocationMap.put(e,loc);	
	}
	
	public Location getLocation(Entity e){
		return entityToLocationMap.get(e);
	}
	
	public void setDeltaX(int x){  //adding this to move map under not done
		deltaX+=x * this.TILE_SCALE;
	}
	
	public void setDeltaY(int y){  //adding this to move map under not done
		deltaY+=y * this.TILE_SCALE;
	}
	
	public void setDelta(Point point){
		this.setDeltaX(point.getX());
		this.setDeltaY(point.getY());
	}
	
	public Point getDelta(){
		return new Point(this.deltaX,this.deltaY);
	}
	public void setAvatar(Avatar avatar){
		this.avatar=avatar;
	}

	public void draw(Graphics g){
		/*
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				int delta1=map[i][j].getDeltaX();
				int delta2=map[i][j].getDeltaY();
				map[i][j].setDeltaX(delta1+deltaX);  
				map[i][j].setDeltaY(delta2+deltaY);  
				map[i][j].draw(g);
				
				
			}
		}
		*/
		///*
		Location location= getLocation(avatar);
		int lowX=location.getX()-RANGE;
		int highX=location.getX()+RANGE;
		int lowY=location.getY()-RANGE;
		int highY=location.getY()+RANGE;
		for(int i=lowX;i<=highX;i++){
			for(int j=lowY;j<=highY;j++){
				int delta1=map[i][j].getDeltaX();
				int delta2=map[i][j].getDeltaY();
				map[i][j].setDeltaX(delta1+deltaX);  
				map[i][j].setDeltaY(delta2+deltaY);  
				map[i][j].draw(g);
			}
		}
		//*/
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