package model;

import java.awt.image.*;

public class MountainTerrain extends Terrain{
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
