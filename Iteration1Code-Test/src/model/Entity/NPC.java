package model.Entity;

import java.awt.image.BufferedImage;

import model.AreaEffect;
import model.occupation.Terminator;
import model.occupation.Occupation;
import utilities.ImageProcessing;
import utilities.Scaling;
import utilities.SpriteSheetUtility;

public abstract class NPC extends Entity {
	private BufferedImage image;
	private BufferedImage[] spriteSheet;
	private int state= 0;
	
	public NPC(String role) {
		super(new Terminator());
		String occString = role.toUpperCase();
		SpriteSheetUtility util = new SpriteSheetUtility(occString);
		spriteSheet = (util.getSpriteArray());
		setDirection(2);
		//this.location = new Location(INITIAL_X_LIE, INITIAL_Y_LIE);
	}
	
	public BufferedImage getImage(){
		if(this instanceof Orc )
		{
			if (state==1){
				BufferedImage imageToDisplay = spriteSheet[4];
				image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
				return image;
			}
			else if (state==2){
				BufferedImage imageToDisplay = spriteSheet[5];
				image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
				return image;
			}
			else if(state==3){
				BufferedImage imageToDisplay = spriteSheet[2];
				image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
				return image;
			}
			else
			{
				BufferedImage imageToDisplay = spriteSheet[direction];
				image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
				return image;
			}
			
		}
		else {
			BufferedImage imageToDisplay = spriteSheet[direction];
			image= ImageProcessing.scaleImage(Scaling.AVATAR_WIDTH, Scaling.AVATAR_HEIGHT, imageToDisplay);
			return image;
			
		}
	}
	public void setState(int state){
		this.state=state;
	
	}
	public int getState(){
		return this.state;
	
	}
	
	public abstract AreaEffect getAreaEffect();
	
}
