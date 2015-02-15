package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class SkullAndCrossbonesDecal extends Decal implements Serializable{
	AreaEffect effect;

	public SkullAndCrossbonesDecal(DeathAreaEffect effect){
		super();
		this.effect=effect;
	}
	
	public SkullAndCrossbonesDecal(DamageAreaEffect effect){
		super();
		this.effect=effect;
	}
	/*
	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/skullandcrossbones_decal.png";
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