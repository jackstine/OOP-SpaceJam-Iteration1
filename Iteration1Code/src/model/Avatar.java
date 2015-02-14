package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import utilities.ImagePaths;
import utilities.ImageProcessing;
import utilities.Scaling;
import controller.MapViewController;

public class Avatar extends Entity implements Serializable{
	private Inventory inventory = new Inventory();
	private Location location;   // I dont think this is needed? -Juan
	private final int INITIAL_X = 0;
	private final int INITIAL_Y =0;
	private BufferedImage image;

	public Avatar() {
		this.location = new Location(INITIAL_X,INITIAL_Y);
		//occupation.initializeStats();
	}
	
	public Avatar(Occupation occupation) {
		super(occupation);
	}
	
	
	public void move(int x,int y){ //this is not needed either -Juan
		location.add(x,y);
		//System.out.println(location);
	}
	public void loadImage(Graphics g)
	{	
		image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT,ImagePaths.AVATAR_IMAGE);
		int x= location.getX();
		int y= location.getY();
		g.drawImage(image,100*x,100*y,null);
		
	}
	
	public BufferedImage getImage(){
		image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT,ImagePaths.AVATAR_IMAGE);
		return image;
	}
	
	public Inventory getInventory(){
		return inventory;
	}
	
	
	
	
	/*
	//private void attack() {
	//	
	//}
	//may not need to override
	 */
	
	/*
	//private void useAbility() {
	//	
	//}
	//may not need to override
	 */
	
	
}
