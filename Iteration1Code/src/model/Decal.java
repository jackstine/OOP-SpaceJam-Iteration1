package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Decal{
	
	protected char decalID;
	protected AreaEffect effect;
	
	public Decal() {
		//createImage();
	}
	
	public char getDecalID() {
		return this.decalID;
	}
	
	public String toString() {
		return "Decal:" + this.decalID;
	}
	
	public AreaEffect getAreaEffect() {
		return this.effect;
	}
	/*
	
	public BufferedImage getImage() {
		return image;
	}
	protected abstract String getFilePath();
	
	protected void createImage() {
		try {
			image = ImageIO.read(new File(getFilePath()));	//attempt to find file :)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	public abstract BufferedImage getImage(int scale);
	public abstract BufferedImage getNewImage();
}