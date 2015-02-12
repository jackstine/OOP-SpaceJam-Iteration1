package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public class Tile{
	public static final int SCALE=100;
	private final int OVERLAY_IMAGE_OFFSET = 35;
	
	private Terrain terrain;
	private Location location;
	private Item item;
	private Entity entity;
	//private AreaEffect areaEffect;
	//private Decal decal;
	private int deltaX; 
	private int deltaY;

	public Tile(Terrain terrain, int x,int y){ //will take more parameters(maybe)
		this.terrain=terrain;
		location= new Location(x,y);
		deltaX=0;
		deltaY=0;
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
	
	public int getDeltaX(){           //used to move map under //not done
		return deltaX;
	}
	
	public int getDeltaY(){
		return deltaY;
	}
	
	public void setDeltaX(int deltaX){
		this.deltaX+=deltaX;
	}
	
	public void setDeltaY(int deltaY){
		this.deltaY+=deltaY;
	}

	public void setItem(Item item){
		this.item = item;
	}
	
	public Item getItem(){
		return this.item;
	}
	
	public void draw(Graphics g){
		BufferedImage imageToDisplay = terrain.getImage();
		BufferedImage itemImage;
		int x= location.getX();
		int y= location.getY();
		//if has Item overlay
		if (item != null){
			System.out.println(this.item);
			itemImage = this.item.getImage(SCALE-OVERLAY_IMAGE_OFFSET);
			imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageToDisplay, itemImage);
		}
		g.drawImage(imageToDisplay,SCALE*x+deltaX,SCALE*y+deltaY,null);
	}

}