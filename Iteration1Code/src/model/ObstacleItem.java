package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public abstract class ObstacleItem implements Item {

	protected String ITEM_IMAGE;
	protected String ITEM_NAME;
	
	public abstract boolean action(Avatar avatar);
	
	public BufferedImage getImage(int scale){
		return ImageProcessing.scaleImage(scale, scale, ITEM_IMAGE);
	}
	
	public String getImagePath(){
		return ITEM_IMAGE;
	}
}
