package model;

import java.awt.image.BufferedImage;

import model.ExperienceAreaEffect;

public class GoldStarDecal extends Decal {
	
	ExperienceAreaEffect effect;

	public GoldStarDecal(){
		super();
		effect= new ExperienceAreaEffect();
		this.decalID = '*';
	}	
	
	public BufferedImage getImage(int scale){
		return DecalImageProxy.getDecalImage(this);
	}
	public BufferedImage getNewImage(){
		return DecalImageProxy.getNewDecalImage(this);
	}
	
	public AreaEffect getAreaEffect(){
		return effect;
	}
}