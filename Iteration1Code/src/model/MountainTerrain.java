package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;


public class MountainTerrain extends Terrain{
	private boolean passable;
	private BufferedImage image;

	public MountainTerrain(){
		passable=false;
		/*
		try{
		image= ImageIO.read(new File("waste.png"));
		} catch(IOException e){

		}
		*/
		//need to add image for this
	}

	public boolean isPassable() {
		return passable;
	}

	public BufferedImage getImage(){
		return image;
	}


}
