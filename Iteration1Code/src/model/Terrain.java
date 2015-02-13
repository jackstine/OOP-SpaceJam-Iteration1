package model;

import java.awt.image.*;

public abstract class Terrain {
	
	private boolean passable;

	public abstract boolean isPassable();

	public BufferedImage getImage(){
		return TerrainImageProxy.getTerrainImage(this);
	}
}
