package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public final class ItemImageProxy  {
	private static String HEALINGPOTION_IMAGE_PATH = "src/res/img/healing_potion.png";
	private static String[] TREASURECHEST_IMAGE_PATH = {"src/res/img/ClosedTreasureChest.png","src/res/img/OpenTreasureChest.png"};
	private static String ARMOR_IMAGE = "src/res/img/armor.png";
	private static String WEAPON_IMAGE ="src/res/img/weapon.png";
	private static String GIANT_ROCK_IMAGE ="src/res/img/giant_rock.png";
	private static String DAVE = "src/res/img/dave.jpg";
	
	private static BufferedImage healingpotionImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  HEALINGPOTION_IMAGE_PATH);
	private static BufferedImage closedtreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[0]);
	private static BufferedImage opentreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[1]);
	private static BufferedImage armorImage= ImageProcessing.scaleImage(Scaling.TILE_TAKEABLE_ITEM_OFFSET, ARMOR_IMAGE);
	private static BufferedImage weaponImage= ImageProcessing.scaleImage(Scaling.TILE_TAKEABLE_ITEM_OFFSET, WEAPON_IMAGE);
	private static BufferedImage giantRockImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, GIANT_ROCK_IMAGE);
	private static BufferedImage dave = ImageProcessing.scaleImage(Scaling.TILE_SCALE,DAVE);
	
	//TODO maybe we want a set Scale function that when instantiated, will set the scale size of the images
	//TODO  the images in the inventory and Equipment are off centered
	
	public final BufferedImage getImage(HealingOneShotItem item){
		return ItemImageProxy.healingpotionImage;
	}
	
	public final BufferedImage getImage(TreasureChest item){
		if(item.getState() == 0){
			return ItemImageProxy.closedtreasurechestImage; //wrong. need to add open as well
		}
		else{
			return ItemImageProxy.opentreasurechestImage;
		}
	}
	
	//TODO  the decals return the image for this, maybe get rid of decals???
	public final BufferedImage getImage(DamagingOneShotItem item){
		return dave;
	}
	
	public final BufferedImage getImage(Armor item){
		return armorImage;
	}

	public final BufferedImage getImage(Weapon item){
		return weaponImage;
	}
	
	public final BufferedImage getImage(GiantRock item){
		return giantRockImage;
	}
	
	
}
