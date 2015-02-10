package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Decal{
	BufferedImage image;

	public Decal() {
		createImage();
	}
	
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
}