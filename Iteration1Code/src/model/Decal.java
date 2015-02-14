package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public abstract class Decal implements Serializable{
	

	public Decal() {
		//createImage();
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
	public abstract AreaEffect getAreaEffect();
}