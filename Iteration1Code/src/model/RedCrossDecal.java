package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class RedCrossDecal extends Decal implements Serializable{
	//private BufferedImage image;
	HealingAreaEffect effect;

	public RedCrossDecal(){
		super();
		effect= new HealingAreaEffect(.50);
		//image= 
	}
	/*
	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/redcross_decal.png";
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