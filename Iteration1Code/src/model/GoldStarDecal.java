package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class GoldStarDecal extends Decal implements Serializable{

	public GoldStarDecal(){
		super();
	}
	
	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "src/res/img/goldstar_decal.png";
	}
}