package utilities;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.occupation.AvatarAlchemist;
import model.occupation.AvatarHunter;
import model.occupation.AvatarTerminator;
import model.occupation.MerchantHunter;
import model.occupation.OrcTerminator;
import model.occupation.SkeletonAlchemist;

public class GoatSpriteSheetUtility extends SpriteSheetUtility {
	public GoatSpriteSheetUtility() {
		//DEFAULT WILL JUST BE A TERMINATOR FOR SAFETY REASONS
		super();
	}
	
	public GoatSpriteSheetUtility(AvatarAlchemist a) {
		super(a);
	}
	
	public GoatSpriteSheetUtility(AvatarHunter h) {
		super(h);
	}
	
	public GoatSpriteSheetUtility(AvatarTerminator t) {
		super(t);
	}
	
	public GoatSpriteSheetUtility(MerchantHunter m) {
		super(m);
	}
	
	public GoatSpriteSheetUtility(OrcTerminator o) {
		super(o);
	}
	
	public GoatSpriteSheetUtility(SkeletonAlchemist s) {
		super(s);
	}
	
	@Override
	public BufferedImage[] getSpriteArray() {
		BufferedImage[] a = super.getSpriteArray();
		for (int i=0; i < a.length; i++) {
			
			try {
				a[i] = ImageIO.read(new File("src/res/img/goat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
	}
}
