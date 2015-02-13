package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;

import utilities.ImageProcessing;


public class MountainTerrain extends Terrain{
	private boolean passable;
	private final int SCALE=100;
	private final String PATH="src/res/img/mountain.png";
	private BufferedImage image;

	public MountainTerrain(){
		passable=false;
		image=ImageProcessing.scaleImage(SCALE, SCALE, PATH);
	}

	public boolean isPassable() {
		return passable;
	}

	public BufferedImage getImage(){
		return image;
	}


}
