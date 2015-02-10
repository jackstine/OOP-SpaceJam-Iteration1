package model;

import java.awt.image.BufferedImage;

public class SkullAndCrossbonesDecal extends Decal {
	BufferedImage image;

	public SkullAndCrossbonesDecal(){
		//initialize image or get image path
	}

	public BufferedImage getImage(){
		return image;
	}

	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "/res/img/skullandcrossbones_decal.png";
	}
}