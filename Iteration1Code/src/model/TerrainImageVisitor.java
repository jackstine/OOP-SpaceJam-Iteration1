package model;

import java.awt.image.BufferedImage;

public class TerrainImageVisitor implements TerrainVisitor{
	private TerrainImageProxy imageProxy = new TerrainImageProxy();
	private BufferedImage image;

	public void accept(DesertTerrain t){
		this.image = imageProxy.getTerrainImage(t);
	}
	public void accept(MountainTerrain t){
		this.image = imageProxy.getTerrainImage(t);
	}
	public void accept(RadioactiveWasteTerrain t){
		 this.image = imageProxy.getTerrainImage(t);
	}
	public BufferedImage getImage(){
		return this.image;
	}
}
