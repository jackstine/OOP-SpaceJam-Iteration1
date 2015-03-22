package model;

import java.awt.image.BufferedImage;

import model.entity.Entity;

public abstract class Trap {
	protected int detectionLevelRequired=1;
	protected boolean visible=false;
	protected int damage=1;
	protected boolean destroyed=false;
	
	public abstract int getDamage();
	public abstract BufferedImage getImage();
	public abstract void apply(Entity e);
	//true by default
	public boolean isVisible(){return true;}
	
	public int detectionRequired(){
		return detectionLevelRequired;
	}
	
	public void destroy(){
		damage=0;
		visible=false;
		destroyed=true;
	}
	
	public void makeVisible(){
		if(destroyed==false)
		visible=true;		
	}
}
