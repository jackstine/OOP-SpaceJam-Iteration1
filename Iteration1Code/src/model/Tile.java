package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import utilities.ImageProcessing;

public class Tile implements Serializable{
	public static final int SCALE=100;
	private final int OVERLAY_IMAGE_OFFSET = 35;
	
	private boolean dontDraw;
	
	
	private Terrain terrain;
	private Location location;
	private Item item;
	private Entity entity;
	//private AreaEffect areaEffect;
	private Decal decal;
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
		return terrain.isPassable() && !(item instanceof ObstacleItem);  
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
	
	public Item dropItem(){
		Item temp = this.item;
		this.item = null;
		this.updateImage();
		return temp;
	}
	
	public Item getItem(){
		return this.item;
	}
	
	private BufferedImage updateImage(){
		BufferedImage imageOfTerrain = terrain.getImage();
		BufferedImage itemImage,imageToDisplay;
		if (item != null){
			itemImage = this.item.getImage(SCALE-OVERLAY_IMAGE_OFFSET);
			imageOfTerrain = terrain.getNewImage();
			imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain, itemImage);
		}
		else{
			imageToDisplay = imageOfTerrain;
		}
		return imageToDisplay;
	}
	
	public String toString(){
		return "Printing the image at ("+this.location.getX()+","+this.location.getY()+")";
	}
	
	public void draw(Graphics g){
		int x= location.getX();
		int y= location.getY();
		//if has Item overlay
		BufferedImage imageToDisplay = this.updateImage();
		//System.out.println(this+imageToDisplay.toString());
		g.drawImage(imageToDisplay,SCALE*x+deltaX,SCALE*y+deltaY,null);
	}

}