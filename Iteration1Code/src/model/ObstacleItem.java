package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import utilities.ImageProcessing;

public abstract class ObstacleItem implements Item, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1477694977470333609L;
	protected String ITEM_IMAGE;
	
	public abstract boolean action(Avatar avatar);
	
	public BufferedImage getImage(int scale){
		return ImageProcessing.scaleImage(scale, scale, ITEM_IMAGE);
	}
	
	public String getImagePath(){
		return ITEM_IMAGE;
	}
}
