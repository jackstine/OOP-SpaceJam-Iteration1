package utilities;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;

import model.occupation.AvatarAlchemist;
import model.occupation.AvatarHunter;
import model.occupation.AvatarTerminator;
import model.occupation.MerchantHunter;
import model.occupation.OrcTerminator;
import model.occupation.SkeletonAlchemist;

public class StealthSpriteSheetUtility extends SpriteSheetUtility {
	private AlphaComposite ac;
	
	public StealthSpriteSheetUtility() {
		//DEFAULT WILL JUST BE A TERMINATOR FOR SAFETY REASONS
		super();
	}
	
	public StealthSpriteSheetUtility(AvatarAlchemist a) {
		super(a);
	}
	
	public StealthSpriteSheetUtility(AvatarHunter h) {
		super(h);
	}
	
	public StealthSpriteSheetUtility(AvatarTerminator t) {
		super(t);
	}
	
	public StealthSpriteSheetUtility(MerchantHunter m) {
		super(m);
	}
	
	public StealthSpriteSheetUtility(OrcTerminator o) {
		super(o);
	}
	
	public StealthSpriteSheetUtility(SkeletonAlchemist s) {
		super(s);
	}
	
	@Override
	public BufferedImage[] getSpriteArray() {
		BufferedImage[] a = super.getSpriteArray();
		for (int i=0; i < a.length; i++) {
			BufferedImage tmpImg = new BufferedImage(a[i].getWidth(), a[i].getHeight(), 
                    BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.3f)); 
			// set the transparency level in range 0.0f - 1.0f 
			g2d.drawImage(a[i], 0, 0, null);
			a[i] = tmpImg;
		}
		
		return a;
	}
}
