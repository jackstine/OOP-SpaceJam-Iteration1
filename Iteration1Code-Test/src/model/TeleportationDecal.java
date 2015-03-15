package model;

import java.awt.image.BufferedImage;

public class TeleportationDecal extends Decal {
	
	public TeleportationDecal(){
		super();
		this.effect= new TeleportationAreaEffect();
		this.decalID = 'O';
	}
	
	public BufferedImage getImage(int scale){
		return DecalImageProxy.getDecalImage(this);
	}
	public BufferedImage getNewImage(){
		return DecalImageProxy.getNewDecalImage(this);
	}	
}
