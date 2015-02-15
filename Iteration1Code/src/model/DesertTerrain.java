package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class DesertTerrain extends Terrain {
	
	private boolean passable;
	
	public DesertTerrain(){
		passable=true;
		terrainID='D';
	}

	public boolean isPassable() {
		return passable;
	}
	
	public BufferedImage getImage(){
		return TerrainImageProxy.getTerrainImage(this);
	}
	public BufferedImage getNewImage(){
		return TerrainImageProxy.getNewTerrainImage(this);
	}
}
