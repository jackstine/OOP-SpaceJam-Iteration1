package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public final class ItemImageProxy  {
	public static String HEALINGPOTION_IMAGE_PATH = "src/res/img/healing_potion.png";
	public static String[] TREASURECHEST_IMAGE_PATH = {"src/res/img/ClosedTreasureChest.png","src/res/img/OpenTreasureChest.png"};
	
	
	public static BufferedImage healingpotionImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  HEALINGPOTION_IMAGE_PATH);
	public static BufferedImage closedtreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[0]);
	public static BufferedImage opentreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[1]);
	
	public final static BufferedImage getItemImage(HealingOneShotItem item){
		return ItemImageProxy.healingpotionImage;
	}
	
	
	public final static BufferedImage getNewItemImage(HealingOneShotItem item){
		return ImageProcessing.scaleImage(Scaling.TILE_SCALE, HEALINGPOTION_IMAGE_PATH);
	}
	
	public final static BufferedImage getItemImage(TreasureChest item, int state){
		if(state==0){
		return ItemImageProxy.closedtreasurechestImage; //wrong. need to add open as well
		}
		else{
			return ItemImageProxy.opentreasurechestImage;
		}
	}
	
	
	public final static BufferedImage getNewItemImage(TreasureChest item, int state){
		return ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[state]);
	}
	

}
