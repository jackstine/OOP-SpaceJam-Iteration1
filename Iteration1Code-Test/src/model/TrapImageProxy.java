package model;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;

public class TrapImageProxy {
	private static String SPIKETRAP_IMAGE_PATH = "src/res/img/SpikeTrap.jpg";
	public static BufferedImage spikeTrap = ImageProcessing.scaleImage(Scaling.TILE_SCALE,  SPIKETRAP_IMAGE_PATH);
	
	public final static BufferedImage getTrapImage(SpikeTrap trap){
		return TrapImageProxy.spikeTrap;
	}
	
}
