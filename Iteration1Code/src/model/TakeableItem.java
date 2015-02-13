package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public abstract class TakeableItem implements Item {
	protected String ITEM_IMAGE;
	
	public abstract void action(Entity entity);
	
	public abstract int getBonus();
	
	//TODO make sure that images of ITEMs are in a MAP
	public BufferedImage getImage(int scale){
		return ImageProcessing.scaleImage(scale, scale, ITEM_IMAGE);
	}
	
	public String getImagePath(){
		return ITEM_IMAGE;
	}
}
