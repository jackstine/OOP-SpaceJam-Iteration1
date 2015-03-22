package model;

import java.awt.image.BufferedImage;

import model.entity.Entity;

public class SpikeTrap extends Trap {
		
	
	public SpikeTrap(){
		damage=10;
		visible=false;
		detectionLevelRequired=3;
	}
	
	public int getDamage(){
		return damage;
	}
	public void apply(Entity e) {
		TrapDamageApplication.apply(e, this);
		this.visible = true;
	}

	
	public BufferedImage getImage(){
		return TrapImageProxy.getTrapImage(this);
	}
	
	
	public boolean isVisible(){return visible;}
	
}
