package model.items;

import java.awt.image.BufferedImage;

import model.Point;

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
	public void accept(TwoHandedWeapon w) {
		this.image = imageProxy.getImage(w);
	}
	public void accept(Gloves gloves) {
		this.image = imageProxy.getImage(gloves);
	}
	public void accept(Leggings leggings) {
		this.image = imageProxy.getImage(leggings);
	}
	public void accept(Shield shield) {
		this.image = imageProxy.getImage(shield);
	}
	public void accept(Helmet helmet) {
		this.image = imageProxy.getImage(helmet);	
	}
	public void accept(Boots boots){
		this.image = imageProxy.getImage(boots);
	}
	public void accept(Projectile projectile){
		this.image = imageProxy.getImage(projectile);
	}
}
