package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public final class TerrainImageProxy {
	public static String TERRAIN_IMAGE_PATH = "src/res/img/terrain.jpg";
	public static String DESSERT_IMAGE_PATH = "src/res/img/desert.png";
	public static String RADIO_ACTIVE_IMAGE_PATH = "src/res/img/waste.png";
	public static String MOUNTAIN_IMAGE_PATH = "src/res/img/mountain.png";
	public static Point TILE_SCALE = new Point(100,100);
	
	public static BufferedImage terrainImage = ImageProcessing.scaleImage(TILE_SCALE, TERRAIN_IMAGE_PATH);
	public static BufferedImage dessertImage = ImageProcessing.scaleImage(TILE_SCALE, DESSERT_IMAGE_PATH);
	public static BufferedImage radioActiveImage = ImageProcessing.scaleImage(TILE_SCALE, RADIO_ACTIVE_IMAGE_PATH);
	public static BufferedImage mountainImage = ImageProcessing.scaleImage(TILE_SCALE, MOUNTAIN_IMAGE_PATH);

	//Create a getTerrainImage()  for all types of terrain
	public final static BufferedImage getTerrainImage(Terrain ter){
		return TerrainImageProxy.terrainImage;
	}
	
	public final static BufferedImage getTerrainImage(DesertTerrain des){
		return TerrainImageProxy.dessertImage;
	}
	
	public final BufferedImage getTerrainImage(MountainTerrain mon){
		return TerrainImageProxy.mountainImage;
	}
	
	public final BufferedImage getTerrainImage(RadioactiveWasteTerrain waste){
		return TerrainImageProxy.radioActiveImage;
	}

}
