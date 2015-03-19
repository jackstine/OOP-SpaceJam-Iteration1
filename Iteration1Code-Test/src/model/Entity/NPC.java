package model.Entity;

import java.awt.image.BufferedImage;

import model.occupation.*;
import utilities.*;

public abstract class NPC extends Entity {
	private BufferedImage image;
	private BufferedImage[] spriteSheet;
	
	public NPC() {
		super(new Terminator());
		SpriteSheetUtility util = this.getSpriteSheet();
		this.spriteSheet = (util.getSpriteArray());
		setDirection(2);
		//this.location = new Location(INITIAL_X_LIE, INITIAL_Y_LIE);
	}
	
	public abstract SpriteSheetUtility getSpriteSheet();
	
	public BufferedImage getImage(){
			BufferedImage imageToDisplay = spriteSheet[direction];
			image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
			return image;
	}
}
