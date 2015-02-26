package model.items;

import java.awt.image.BufferedImage;

import model.Point;
import utilities.ImageProcessing;
import utilities.Scaling;

public final class ItemImageProxy  {
	private static String HEALINGPOTION_IMAGE_PATH = "src/res/img/healing_potion.png";
	private static String[] TREASURECHEST_IMAGE_PATH = {"src/res/img/ClosedTreasureChest.png","src/res/img/OpenTreasureChest.png"};
	private static String ARMOR_IMAGE = "src/res/img/armor.png";
	private static String WEAPON_IMAGE ="src/res/img/weapon.png";
	private static String GIANT_ROCK_IMAGE ="src/res/img/giant_rock.png";
	private static String DAVE = "src/res/img/dave.jpg";
	private static String TWO_HANDED_WEAPON_IMAGE = "src/res/img/two_handed_weapon.png";
	private static String HELMET_IMAGE = "src/res/img/helmet.png";
	private static String LEGGINGS_IMAGE = "src/res/img/leggings.png";
	private static String GLOVES_IMAGE = "src/res/img/gloves.png";
	private static String SHIELD_IMAGE = "src/res/img/shield.png";
	private static String BOOTS_IMAGE = "src/res/img/boots.png";
	private static String PROJECTILE_IMAGE = "src/res/img/projectile.png";
	
	private BufferedImage healingpotionImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  HEALINGPOTION_IMAGE_PATH);
	private BufferedImage closedtreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[0]);
	private BufferedImage opentreasurechestImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, TREASURECHEST_IMAGE_PATH[1]);
	private BufferedImage armorImage;
	private BufferedImage weaponImage;
	private BufferedImage giantRockImage= ImageProcessing.scaleImage(Scaling.TILE_SCALE, GIANT_ROCK_IMAGE);
	private BufferedImage daveImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,DAVE);
	private BufferedImage twoHandedWeaponImage;
	private BufferedImage helmetImage;
	private BufferedImage bootsImage;
	private BufferedImage glovesImage;
	private BufferedImage leggingsImage;
	private BufferedImage shieldImage;
	private BufferedImage projectileImage;
	
	
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
		twoHandedWeaponImage = ImageProcessing.scaleImage(this.scale, TWO_HANDED_WEAPON_IMAGE);
		helmetImage = ImageProcessing.scaleImage(this.scale, HELMET_IMAGE);
		bootsImage = ImageProcessing.scaleImage(this.scale, BOOTS_IMAGE);
		glovesImage = ImageProcessing.scaleImage(this.scale, GLOVES_IMAGE);
		leggingsImage = ImageProcessing.scaleImage(this.scale, LEGGINGS_IMAGE);
		shieldImage = ImageProcessing.scaleImage(this.scale, SHIELD_IMAGE);
		projectileImage = ImageProcessing.scaleImage(this.scale, PROJECTILE_IMAGE);
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
		return daveImage;
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

	public BufferedImage getImage(TwoHandedWeapon w) {
		return twoHandedWeaponImage;
	}
	public BufferedImage getImage(Helmet helmet){
		return helmetImage;
	}
	public BufferedImage getImage(Leggings leg){
		return leggingsImage;
	}
	public BufferedImage getImage(Gloves glo){
		return glovesImage;
	}
	public BufferedImage getImage(Shield s){
		return shieldImage;
	}
	public BufferedImage getImage(Boots b){
		return bootsImage;
	}
	public BufferedImage getImage(Projectile projectile) {
		return projectileImage;
	}
}
