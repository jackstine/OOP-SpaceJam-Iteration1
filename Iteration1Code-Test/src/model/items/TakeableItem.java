package model.items;

import java.awt.image.BufferedImage;

import model.entity.Avatar;
import utilities.ImageProcessing;

public abstract class TakeableItem implements Item {
	protected String ITEM_IMAGE;
	protected String ITEM_NAME;
	
	public abstract boolean action(Avatar avatar);
	
	public abstract int getBonus();
	
	//TODO make sure that images of ITEMs are in a MAP
	public BufferedImage getImage(int scale){
		return ImageProcessing.scaleImage(scale, scale, ITEM_IMAGE);
	}
	
	public String getImagePath(){
		return ITEM_IMAGE;
	}
}
