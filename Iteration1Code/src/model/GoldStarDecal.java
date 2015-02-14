package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import model.ExperienceAreaEffect;

public class GoldStarDecal extends Decal implements Serializable{
	ExperienceAreaEffect effect;

	public GoldStarDecal(){
		super();
		effect= new ExperienceAreaEffect();
	}
	/*
	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/goldstar_decal.png";
	}
	*/
	
	
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