package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class DesertTerrain extends Terrain{
	private boolean passable;
	private BufferedImage image;

	public DesertTerrain(){
		passable=true;
		try{
		image= ImageIO.read(new File("desert.png"));
		} catch(IOException e){

		}
	}

	public boolean isPassable() {
		return passable;
	}

	public BufferedImage getImage(){
		return image;
	}



}
