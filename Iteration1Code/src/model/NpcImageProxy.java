package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public class NpcImageProxy {
	private static String VILLAGER_IMAGE_PATH = "src/res/img/villager.png";
	
	private BufferedImage villagerImage = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  VILLAGER_IMAGE_PATH);

private Point scale;
	
	
	public NpcImageProxy(Point scale){
		this.scale = scale;
		this.setImages();
	}
	private void setImages(){
		villagerImage= ImageProcessing.scaleImage(this.scale, VILLAGER_IMAGE);
	}
	
	public final BufferedImage getImage(Villager item){
		return villagerImage;
	}

}
