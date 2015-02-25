package model;

import java.awt.image.BufferedImage;

public class RedCrossDecal extends Decal {
	//private BufferedImage image;

	public RedCrossDecal(){
		super();
		this.effect= new HealingAreaEffect(.50);
		this.decalID = '+';
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
}