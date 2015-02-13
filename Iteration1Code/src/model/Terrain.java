package model;

import java.awt.image.BufferedImage;

public abstract class Terrain {

	public abstract boolean isPassable();
	
	public abstract BufferedImage getImage();
	public abstract BufferedImage getNewImage();
}
