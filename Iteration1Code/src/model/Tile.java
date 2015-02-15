package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import utilities.ImageProcessing;
import utilities.Scaling;

public class Tile implements Serializable{
	private boolean dontDraw;
	
	
	private Terrain terrain;
	private Location location;
	private Item item;
	private Entity entity;
	private AreaEffect areaEffect;
	private Decal decal;
	private int deltaX; 
	private int deltaY;

	public Tile(Terrain terrain, int x,int y){ //will take more parameters(maybe)
		this.terrain=terrain;
		location= new Location(x,y);
		deltaX=0;
		deltaY=0;
	}  
	
	//might not need it
	public Tile(Terrain terrain, Decal decal, int x, int y){
		this.terrain=terrain;
		location= new Location(x,y);
		deltaX=0;
		deltaY=0;
		decal= new RedCrossDecal();
			
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
	
	public Decal getDecal(){
		return decal;
	}
	
	public void setDecal(Decal decal){
			this.decal=decal;
	}
	
	public AreaEffect getAreaEffect(){
		return areaEffect;
	}
	
	private BufferedImage updateImage(){
		
		BufferedImage imageOfTerrain = terrain.getImage();
		BufferedImage itemImage,imageToDisplay, decalImage; //added decalImage
		
		if (item != null){
			// Assuming that the Tile WIDTH is equal to the HEIGHT
			itemImage = this.item.getImage(Scaling.TILE_WIDTH-Scaling.TILE_OVERLAY_IMAGE_OFFSET);
			imageOfTerrain = terrain.getNewImage();
			imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,itemImage);
		}
		
		if(decal!=null){
			decalImage = this.decal.getImage(Scaling.TILE_WIDTH-Scaling.TILE_OVERLAY_IMAGE_OFFSET);
			imageOfTerrain = terrain.getNewImage();
			imageToDisplay = ImageProcessing.overlayImagesBottomLeftCorner(imageOfTerrain,decalImage);
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
		g.drawImage(imageToDisplay,Scaling.TILE_WIDTH*x+deltaX,Scaling.TILE_HEIGHT*y+deltaY,null);
		
	}

}