package model;

import java.awt.image.BufferedImage;

public class RedCrossDecal extends Decal{

	public RedCrossDecal(){
		super();
	}

	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/redcross_decal.png";
	}
}