package model;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Tile{
	private Terrain terrain;
	private Location location;
	//private Item item;
	private Entity entity;
	//private AreaEffect areaEffect;
	//private Decal decal;
	private final int SCALE=100;
	private int delta;  //will be deltaX and deltaY in the future

	public Tile(Terrain terrain, int x,int y){ //will take more parameters(maybe)
		this.terrain=terrain;
		location= new Location(x,y);
		delta=0;
	}
	/*
	public Tile getTile(){  //not sure if this is needed. Leaving it here for later
		return this;
	}
	*/ 
	
	public Location getLocation(){  // can be deleted later. Used for debugging.
		return location;
	}

	public boolean isPassable(){
		return terrain.isPassable();
	}
	//will probably need to add a setTerrain for the purpose
	//of making the map 
 
	public void setTerrain(Terrain ter){  
		terrain=ter;
	}

	public Terrain getTerrain(){
		return terrain;
	}
	
	public int getDelta(){           //used to move map under //not done
		return delta;
	}
	
	public void setDelta(int delta){
		this.delta+=delta;
	}

	public void draw(Graphics g){
		BufferedImage image= terrain.getImage();
		int x= location.getX();
		int y= location.getY();
		g.drawImage(image,SCALE*x+delta,SCALE*y+delta,null);
	}

}