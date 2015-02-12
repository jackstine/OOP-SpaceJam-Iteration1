package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public abstract class TakeableItem implements Item {
	protected String ITEM_IMAGE;
	
	public abstract boolean action(Avatar avatar);
	
	public abstract int getBonus();
	
	//TODO make sure that images of ITEMs are in a MAP
	public BufferedImage getImage(int scale){
		return ImageProcessing.scaleImage(scale, scale, ITEM_IMAGE);
	}
}
