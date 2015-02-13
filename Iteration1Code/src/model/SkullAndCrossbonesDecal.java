package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class SkullAndCrossbonesDecal extends Decal implements Serializable{

	public SkullAndCrossbonesDecal(){
		super();
	}

	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/skullandcrossbones_decal.png";
	}
}