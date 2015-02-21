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
	
	private BufferedImage healingpotionImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  HEALINGPOTION_IMAGE_PATH);
	private BufferedImage closedtreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[0]);
	private BufferedImage opentreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[1]);
	private BufferedImage armorImage;
	private BufferedImage weaponImage;
	private BufferedImage giantRockImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, GIANT_ROCK_IMAGE);
	private BufferedImage dave = ImageProcessing.scaleImage(Scaling.TILE_SCALE,DAVE);
	
	private Point scale;
	
	//TODO maybe we want a set Scale function that when instantiated, will set the scale size of the images
	//TODO  the images in the inventory and Equipment are off centered
	
	public ItemImageProxy(Point scale){
		this.scale = scale;
		this.setImages();
	}
	
	private void setImages(){
		armorImage= ImageProcessing.scaleImage(this.scale, ARMOR_IMAGE);
		weaponImage= ImageProcessing.scaleImage(this.scale, WEAPON_IMAGE);
	}
	
	public final BufferedImage getImage(HealingOneShotItem item){
		return healingpotionImage;
	}
	
	public final BufferedImage getImage(TreasureChest item){
		if(item.getState() == 0){
			return closedtreasurechestImage; //wrong. need to add open as well
		}
		else{
			return opentreasurechestImage;
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
