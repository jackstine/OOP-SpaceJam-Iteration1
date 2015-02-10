package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class RadioactiveWasteTerrain extends Terrain{
	private boolean passable;
	private BufferedImage image;

	public RadioactiveWasteTerrain(){
		passable=false;
		try{
		image= ImageIO.read(new File("waste.png"));
		} catch(IOException e){

		}
	}

	public boolean isPassable(){
		return passable;
	}

	public BufferedImage getImage(){
		return image;
	}

}
