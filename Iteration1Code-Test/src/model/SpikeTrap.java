package model;

import java.awt.image.BufferedImage;

import model.Entity.Entity;
import utilities.ImageProcessing;
import utilities.Scaling;

public class SpikeTrap extends Trap {
	private int damage=10;
	private int detectionLevelRequired=5;
	private boolean isVisible=false; //need to implement level stuff.
	
	
	public int getDamage(){
		return damage;
	}
	public void apply(Entity e) {
		TrapDamageApplication.apply(e, this);
	}
	
	public int detectionRequired(){
		return detectionLevelRequired;
	}
	
	public boolean isVisible(){
		return isVisible;
	}
	
	public void setVisible(boolean isVisible){
		this.isVisible=isVisible;
	}
	
	public BufferedImage getImage(){
		return TrapImageProxy.getTrapImage(this);
	}
	
}
