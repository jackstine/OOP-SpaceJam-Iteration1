package model;

import java.awt.image.BufferedImage;

public abstract class Terrain {
	
	private boolean passable;

	public abstract boolean isPassable();
	
	public abstract BufferedImage getImage();
}
