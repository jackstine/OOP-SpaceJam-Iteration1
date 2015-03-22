package utilities;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.entity.*;
import model.entity.Orc;
import model.occupation.*;

public class SpriteSheetUtility {
	private String imagePath = "";
	private BufferedImage image;
	private BufferedImage sprite;
	private BufferedImage[] spriteArray = new BufferedImage[10];
	private final int width = 40;
	private final int height = 50;
	private int offsetX, offsetY;
	public static final String HUNTER = "HUNTER";
	public static final String TERMINATOR = "TERMINATOR";
	public static final String ALCHEMIST = "ALCHEMIST";
	public static final String MERCHANT = "MERCHANT";
	public static final String SKELETON = "SKELETON";
	public static final String ORC = "ORC";
	
	
	public SpriteSheetUtility() {
		//DEFAULT WILL JUST BE A TERMINATOR FOR SAFETY REASONS
		imagePath = "src/res/img/terminator_spritesheet.png";
		initializeSpriteArray();
	}
	
	public SpriteSheetUtility(AvatarAlchemist a) {
		imagePath = "src/res/img/alchemist_spritesheet.png";
		initialize();
	}
	
	public SpriteSheetUtility(AvatarHunter h) {
		imagePath = "src/res/img/hunter_spritesheet.png";
		initialize();
	}
	
	public SpriteSheetUtility(AvatarTerminator t) {
		imagePath = "src/res/img/terminator_spritesheet.png";
		initialize();
	}
	
	public SpriteSheetUtility(MerchantHunter m) {
		imagePath = "src/res/img/merchant_spritesheet.png";
		initialize();
	}
	
	public SpriteSheetUtility(OrcTerminator o) {
		imagePath = "src/res/img/orc_spritesheet.png";
		initialize();
	}
	
	public SpriteSheetUtility(SkeletonAlchemist s) {
		imagePath = "src/res/img/skeleton_spritesheet.png";	
		initialize();
	}
	
	protected void initialize() {
		try {
			image = ImageIO.read(new File(imagePath));
		} 
		
		catch(IOException e) {
			System.err.println("LOL 404 IMAGE NOT FOUND");
		}
		initializeSpriteArray();
	}
	
	public BufferedImage[] getSpriteArray() {
		return spriteArray;
	}
	
	public String getPath() {
		return imagePath;
	}
	
	protected void initializeSpriteArray() {
		for (int i=0; i<10; i++) {
			spriteArray[i] = getSpriteByDirection(i);
		}
	}
	
	private BufferedImage getSpriteByDirection(int direction) {
		switch (direction) {
		
		case 0: { //DANCING PART 1
			return getSprite(142,781);
		}
		case 1: { //SOUTH_WEST
			return getSprite(13,332);
		}
		case 2: { //SOUTH
			return getSprite(13,140);
		}
		case 3: { //SOUTH_EAST
			return getSprite(13,460);
		}
		case 4: { //WEST
			return getSprite(332,588);
		}
		case 5: { //DANCING PART 2
			return getSprite(270,781);
		}
		case 6: { //EAST
			return getSprite(332,716);
		}
		case 7: { //NORTH_WEST
			BufferedImage temp = getSprite(140,1038);
			
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-temp.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,
		        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    return op.filter(temp, null);
		}
		case 8: { //NORTH
			return getSprite(13,13);
		}
		case 9: { //NORTH_EAST
			return getSprite(140,1038);
		}
		default: {//NORTH??
			return getSprite(13,13);
		}
		}
	}
	
	private BufferedImage getSprite(int offsetX, int offsetY) {
		BufferedImage subSprite = image.getSubimage(offsetX, offsetY, width, height);
		return subSprite;
	}
	
}
