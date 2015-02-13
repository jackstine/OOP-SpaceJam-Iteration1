package model;

import java.awt.image.*;
import java.io.Serializable;

public class MountainTerrain extends Terrain implements Serializable{
	private boolean passable;

	public MountainTerrain(){
		passable=false;
	}

	public boolean isPassable() {
		return passable;
	}
	
	public BufferedImage getImage(){
		return TerrainImageProxy.getTerrainImage(this);
	}
}
