package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class RadioactiveWasteTerrain extends Terrain {

	private boolean passable;

	public RadioactiveWasteTerrain(){
		passable=false;
		terrainID='R';
	}

	public boolean isPassable(){
		return passable;
	}
	
	public BufferedImage getImage(){
		return TerrainImageProxy.getTerrainImage(this);
	}
	public BufferedImage getNewImage(){
		return TerrainImageProxy.getNewTerrainImage(this);
	}
}
