package model;

import java.awt.image.BufferedImage;

import model.Entity.Entity;

public class SpikeTrap extends Trap {
	private int damage=10;
	private int detectionLevelRequired=5;
	private boolean visible = false; //need to implement level stuff.
	
	
	public int getDamage(){
		return damage;
	}
	public void apply(Entity e) {
		TrapDamageApplication.apply(e, this);
		this.visible = true;
	}
	
	public int detectionRequired(){
		return detectionLevelRequired;
	}
	
	public BufferedImage getImage(){
		return TrapImageProxy.getTrapImage(this);
	}
	
	public boolean isVisible(){return visible;}
	
}
