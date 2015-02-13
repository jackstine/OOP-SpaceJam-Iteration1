package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class RadioactiveWasteTerrain extends Terrain implements Serializable{
	private static final long serialVersionUID = 7458223L;
	private boolean passable;

	public RadioactiveWasteTerrain(){
		passable=false;	
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
