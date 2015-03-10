package model.visitor;

import java.awt.image.BufferedImage;

import model.Point;
import model.items.AlchemistWeapon;
import model.items.Armor;
import model.items.Boots;
import model.items.DamagingOneShotItem;
import model.items.GiantRock;
import model.items.Gloves;
import model.items.HealingOneShotItem;
import model.items.Helmet;
import model.items.HunterWeapon;
import model.items.Leggings;
import model.items.Projectile;
import model.items.Shield;
import model.items.TerminatorBrawling;
import model.items.TerminatorSingleWeapon;
import model.items.TerminatorTwoHandedWeapon;
import model.items.TreasureChest;

public class ItemImageVisitor implements ItemVisitor{
	private ItemImageProxy imageProxy;
	private BufferedImage image;
	
	public ItemImageVisitor(Point scale){
		imageProxy = new ItemImageProxy(scale);
	}
	
	public void accept(Armor a) {
		this.image = imageProxy.getImage(a);
	}
	
	public void accept(TerminatorSingleWeapon w) {
		this.image = imageProxy.getImage(w);
	}
	public void accept(AlchemistWeapon a){
		this.image = imageProxy.getImage(a);
	}
	public void accept(HunterWeapon h){
		this.image = imageProxy.getImage(h);
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
	public void accept(TerminatorTwoHandedWeapon thw) {
		this.image = imageProxy.getImage(thw);
	}
	public void accept(TerminatorBrawling terminatorBrawling) {
		this.image = imageProxy.getImage(terminatorBrawling);
	}
}
