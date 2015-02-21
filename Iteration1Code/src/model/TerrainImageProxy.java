package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public final class TerrainImageProxy {
	private static String DESSERT_IMAGE_PATH = "src/res/img/desert.png";
	private static String RADIO_ACTIVE_IMAGE_PATH = "src/res/img/waste.png";
	private static String MOUNTAIN_IMAGE_PATH = "src/res/img/mountain.png";
	
	private static BufferedImage dessertImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE, DESSERT_IMAGE_PATH);
	private static BufferedImage radioActiveImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE, RADIO_ACTIVE_IMAGE_PATH);
	private static BufferedImage mountainImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE, MOUNTAIN_IMAGE_PATH);

	
	public BufferedImage getTerrainImage(DesertTerrain des){
		return TerrainImageProxy.dessertImage;
	}
	
	public BufferedImage getTerrainImage(MountainTerrain mon){
		return TerrainImageProxy.mountainImage;
	}
	
	public BufferedImage getTerrainImage(RadioactiveWasteTerrain waste){
		return TerrainImageProxy.radioActiveImage;
	}
}
