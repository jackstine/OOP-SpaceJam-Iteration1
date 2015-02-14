package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class DesertTerrain extends Terrain implements Serializable{
	private static final long serialVersionUID = 1777855L;
	private boolean passable;
	
	public DesertTerrain(){
		passable=true;
		terrain_id='d';
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
