package model;

import java.awt.image.BufferedImage;

public class RedCrossDecal extends Decal{
	BufferedImage image;

	public RedCrossDecal(){
		super();
	}

	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "/res/img/redcross_decal.png";
	}
}