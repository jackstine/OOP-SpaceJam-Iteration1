package model;

import java.awt.image.BufferedImage;

public class ItemImageVisitor implements ItemVisitor{
	private ItemImageProxy imageProxy;
	private BufferedImage image;
	
	public ItemImageVisitor(Point scale){
		imageProxy = new ItemImageProxy(scale);
	}
	
	public void accept(Armor a) {
		this.image = imageProxy.getImage(a);
	}
	
	public void accept(Weapon w) {
		this.image = imageProxy.getImage(w);
	}
	
	public void accept(GiantRock g) {
		this.image = imageProxy.getImage(g);
	}
	
	public void accept(HealingOneShotItem h) {
		this.image = imageProxy.getImage(h);
	}
	
	public void accept(DamagingOneShotItem d) {
		this.image = imageProxy.getImage(d);
	}

	public void accept(TreasureChest t) {
		this.image = imageProxy.getImage(t);
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
}
