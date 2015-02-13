package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public final class TerrainImageProxy {
	public static String DESSERT_IMAGE_PATH = "src/res/img/desert.png";
	public static String RADIO_ACTIVE_IMAGE_PATH = "src/res/img/waste.png";
	public static String MOUNTAIN_IMAGE_PATH = "src/res/img/mountain.png";
	public static Point TILE_SCALE = new Point(100,100);
	
	public static BufferedImage dessertImage = ImageProcessing.scaleImage(TILE_SCALE, DESSERT_IMAGE_PATH);
	public static BufferedImage radioActiveImage = ImageProcessing.scaleImage(TILE_SCALE, RADIO_ACTIVE_IMAGE_PATH);
	public static BufferedImage mountainImage = ImageProcessing.scaleImage(TILE_SCALE, MOUNTAIN_IMAGE_PATH);
	
	public final static BufferedImage getTerrainImage(DesertTerrain des){
		return TerrainImageProxy.dessertImage;
	}
	
	public final static BufferedImage getTerrainImage(MountainTerrain mon){
		return TerrainImageProxy.mountainImage;
	}
	
	public final static BufferedImage getTerrainImage(RadioactiveWasteTerrain waste){
		return TerrainImageProxy.radioActiveImage;
	}

}