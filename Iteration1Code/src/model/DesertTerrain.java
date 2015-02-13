package model;

import java.awt.image.*;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;

import utilities.ImageProcessing;

public class DesertTerrain extends Terrain{
	private boolean passable;

	public DesertTerrain(){
		passable=true;
	}

	public boolean isPassable() {
		return passable;
	}
}
