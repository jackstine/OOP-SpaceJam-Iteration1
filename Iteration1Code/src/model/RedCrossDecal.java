package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class RedCrossDecal extends Decal implements Serializable{

	public RedCrossDecal(){
		super();
	}

	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/redcross_decal.png";
	}
}