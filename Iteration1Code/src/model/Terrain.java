package model;

import java.awt.image.BufferedImage;


public abstract class Terrain {
	
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
