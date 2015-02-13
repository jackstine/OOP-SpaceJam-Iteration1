package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;

import utilities.ImageProcessing;

public class DesertTerrain extends Terrain{
	private boolean passable;
	private final int SCALE=100;
	private final String PATH="src/res/img/desert.png";

	public DesertTerrain(){
		passable=true;
	}

	public boolean isPassable() {
		return passable;
	}

	public BufferedImage getImage(){
		return ImageProcessing.scaleImage(SCALE, SCALE, PATH);
	}



}
