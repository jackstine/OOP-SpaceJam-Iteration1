package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public final class TerrainImageProxy {
	public static String DESSERT_IMAGE_PATH = "src/res/img/desert.png";
	public static String RADIO_ACTIVE_IMAGE_PATH = "src/res/img/waste.png";
	public static String MOUNTAIN_IMAGE_PATH = "src/res/img/mountain.png";
	
	public static BufferedImage dessertImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE, DESSERT_IMAGE_PATH);
	public static BufferedImage radioActiveImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE, RADIO_ACTIVE_IMAGE_PATH);
	public static BufferedImage mountainImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE, MOUNTAIN_IMAGE_PATH);
	
	public final static BufferedImage getTerrainImage(DesertTerrain des){
		return TerrainImageProxy.dessertImage;
	}
	
	public final static BufferedImage getTerrainImage(MountainTerrain mon){
		return TerrainImageProxy.mountainImage;
	}
	
	public final static BufferedImage getTerrainImage(RadioactiveWasteTerrain waste){
		return TerrainImageProxy.radioActiveImage;
	}
	
	public final static BufferedImage getNewTerrainImage(DesertTerrain des){
		return ImageProcessing.scaleImage(Scaling.TILE_SCALE, DESSERT_IMAGE_PATH);
	}
	public final static BufferedImage getNewTerrainImage(RadioactiveWasteTerrain waste){
		return ImageProcessing.scaleImage(Scaling.TILE_SCALE, RADIO_ACTIVE_IMAGE_PATH);
	}
	public final static BufferedImage getNewTerrainImage(MountainTerrain mou){
		return ImageProcessing.scaleImage(Scaling.TILE_SCALE, MOUNTAIN_IMAGE_PATH);
	}
	

}
