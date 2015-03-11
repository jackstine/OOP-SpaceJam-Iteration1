package model;

import java.awt.image.BufferedImage;

import model.Entity.Entity;

public abstract class Trap {
	
	public abstract int getDamage();
	public abstract BufferedImage getImage();
	public abstract void apply(Entity e);
	
}
