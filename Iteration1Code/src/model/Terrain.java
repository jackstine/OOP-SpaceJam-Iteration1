package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Terrain implements Serializable{
	
	private boolean passable;

	public abstract boolean isPassable();
	
	public abstract BufferedImage getImage();
	public abstract BufferedImage getNewImage();
}
