package model.Entity;

import java.awt.image.BufferedImage;

import model.occupation.Terminator;
import model.occupation.Occupation;
import utilities.ImageProcessing;
import utilities.Scaling;
import utilities.SpriteSheetUtility;

public abstract class NPC extends Entity {
	private BufferedImage image;
	private BufferedImage[] spriteSheet;
	
	
	public NPC(String role) {
		super(new Terminator());
		String occString = role.toUpperCase();
		SpriteSheetUtility util = new SpriteSheetUtility(occString);
		spriteSheet = (util.getSpriteArray());
		setDirection(2);
		//this.location = new Location(INITIAL_X_LIE, INITIAL_Y_LIE);
	}
	
	public BufferedImage getImage(){
		BufferedImage imageToDisplay = spriteSheet[direction];
		image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
		return image;
	}
}
