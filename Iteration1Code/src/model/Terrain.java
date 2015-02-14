package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Terrain implements Serializable{
	
	private boolean passable;
	protected char terrain_id;
	
	public abstract boolean isPassable();
	
	public abstract BufferedImage getImage();
	public abstract BufferedImage getNewImage();
	
	public char getTerrainID() {
		return terrain_id;
	}
}
