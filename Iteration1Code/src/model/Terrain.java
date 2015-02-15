package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Terrain implements Serializable{
	
	private boolean passable;
	protected char terrainID;
	
	public abstract boolean isPassable();
	
	public abstract BufferedImage getImage();
	public abstract BufferedImage getNewImage();
	
	public char getTerrainID() {
		return terrainID;
	}
	
	public String toString() {
		return "Terrain:" + this.terrainID;
	}
}
