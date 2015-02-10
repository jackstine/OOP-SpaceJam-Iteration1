package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GoldStarDecal extends Decal{
	BufferedImage image;

	public GoldStarDecal(){
		super();
	}
	
	@Override
	protected String getFilePath() {
		//FIX NEXT LINE!! NOT RESOLVING CORRECT PATH
		return "/res/img/goldstar_decal.png";
	}
}