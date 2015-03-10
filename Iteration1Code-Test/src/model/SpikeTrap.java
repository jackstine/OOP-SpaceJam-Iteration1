package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public class SpikeTrap extends Trap {
	private int damage=10;
	private boolean visible=false; //need to implement level stuff.
	
	
	public int getDamage(){
		return damage;
	}
	public void apply(Entity e) {
		TrapDamageApplication.apply(e, this);
	}
	public BufferedImage getImage(){
		return TrapImageProxy.getTrapImage(this);
	}
	
}
