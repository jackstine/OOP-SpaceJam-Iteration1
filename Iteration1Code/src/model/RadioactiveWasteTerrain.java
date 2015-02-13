package model;

import java.awt.image.*;

public class RadioactiveWasteTerrain extends Terrain implements Serializable{
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
}
