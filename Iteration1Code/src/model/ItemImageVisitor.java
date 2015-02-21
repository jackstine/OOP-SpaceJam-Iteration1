package model;

import java.awt.image.BufferedImage;

public class ItemImageVisitor implements ItemVisitor{
	private ItemImageProxy imageProxy = new ItemImageProxy();
	private BufferedImage image;

	public void accept(Armor a) {
		this.image = this.imageProxy.getImage(a);
	}
	
	public void accept(Weapon w) {
		this.image = this.imageProxy.getImage(w);
	}
	
	public void accept(GiantRock g) {
		this.image = this.imageProxy.getImage(g);
	}
	
	public void accept(HealingOneShotItem h) {
		this.image = this.imageProxy.getImage(h);
	}
	
	public void accept(DamagingOneShotItem d) {
		this.image = this.imageProxy.getImage(d);
	}

	public void accept(TreasureChest t) {
		this.image = this.imageProxy.getImage(t);
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
}
