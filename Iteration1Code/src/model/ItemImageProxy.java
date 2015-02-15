package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public final class ItemImageProxy  {
	public static String HEALINGPOTION_IMAGE_PATH = "src/res/img/healing_potion.png";
	
	
	public static BufferedImage healingpotionImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  HEALINGPOTION_IMAGE_PATH);
	
	
	
	public final static BufferedImage getItemImage(HealingOneShotItem item){
		return ItemImageProxy.healingpotionImage;
	}
	
	
	public final static BufferedImage getNewItemImage(HealingOneShotItem item){
		return ImageProcessing.scaleImage(Scaling.TILE_SCALE, HEALINGPOTION_IMAGE_PATH);
	}

}
