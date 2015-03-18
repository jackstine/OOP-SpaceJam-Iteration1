package model;

import java.awt.image.BufferedImage;

public class TeleportationDecal extends Decal {
	private String nextMap;
	
	public TeleportationDecal(String nextMap){
		super();
		this.nextMap=nextMap;
		this.effect= new TeleportationAreaEffect(nextMap);
		this.decalID = 'O';
	}
	
	public BufferedImage getImage(int scale){
		return DecalImageProxy.getDecalImage(this);
	}
	public BufferedImage getNewImage(){
		return DecalImageProxy.getNewDecalImage(this);
	}	
}
