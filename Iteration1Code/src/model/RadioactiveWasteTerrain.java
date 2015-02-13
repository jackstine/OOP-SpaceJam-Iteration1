package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;

import utilities.ImageProcessing;

public class RadioactiveWasteTerrain extends Terrain{
	private boolean passable;

	public RadioactiveWasteTerrain(){
		passable=false;	
	}

	public boolean isPassable(){
		return passable;
	}
	
	public BufferedImage getImage(){
		return TerrainImageProxy.getTerrainImage(this);
	}
}
