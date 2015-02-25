package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public final class TerrainImageProxy {
	private static String DESSERT_IMAGE_PATH = "src/res/img/desert.png";
	private static String RADIO_ACTIVE_IMAGE_PATH = "src/res/img/waste.png";
	private static String MOUNTAIN_IMAGE_PATH = "src/res/img/mountain.png";
	
	private BufferedImage dessertImage;
	private BufferedImage radioActiveImage;
	private BufferedImage mountainImage;
	
	private Point scale;

	public TerrainImageProxy(Point scale){
		this.scale = scale;
		this.setImages();
	}
	
	public void setImages(){
		dessertImage = ImageProcessing.scaleImage(this.scale, DESSERT_IMAGE_PATH);
		radioActiveImage = ImageProcessing.scaleImage(this.scale, RADIO_ACTIVE_IMAGE_PATH);
		mountainImage = ImageProcessing.scaleImage(this.scale, MOUNTAIN_IMAGE_PATH);
	}
	
	public BufferedImage getTerrainImage(DesertTerrain des){
		return dessertImage;
	}
	
	public BufferedImage getTerrainImage(MountainTerrain mon){
		return mountainImage;
	}
	
	public BufferedImage getTerrainImage(RadioactiveWasteTerrain waste){
		return radioActiveImage;
	}
}
