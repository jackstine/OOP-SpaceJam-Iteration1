package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.MapViewController;

public class Avatar extends Entity{
	private Inventory inventory;
	private Location location;
	private final int INITIAL_X = 0;
	private final int INITIAL_Y =0;
	private BufferedImage image;
	
	public Avatar() {
		this.location = new Location(INITIAL_X,INITIAL_Y);
		//occupation.initializeStats();
	}
	public void move(int x,int y){
		location.add(x,y);
		System.out.println(location);
	}
	public void loadImage(Graphics g)
	{	
		try {
			image=ImageIO.read(new File("src/res/img/sprite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int x= location.getX();
		int y= location.getY();
		g.drawImage(image,50*x,50*y,null);
		
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
