package utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.Point;

public class ImageProcessing {
	
	public static BufferedImage getImage(String filename){
		try {
			return ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("THE IMAGE DOES NOT EXIST OR SOMETHING ELSE");
			e.printStackTrace();
			return null;
		}
	}

	public static BufferedImage scaleImage(int width, int height, String filename) {
	    BufferedImage returnImage = null;
	    try {
	        ImageIcon ii = new ImageIcon(filename);//path to image
	        returnImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) returnImage.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, width, height, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return returnImage;
	}
	
	//resizes the image to the width and Height of the image
	public static BufferedImage scaleImage(int width, int height, Image imageToProcess) {
	    BufferedImage returnImage = null;
	    try {
	        returnImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) returnImage.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(imageToProcess, 0, 0, width, height, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return returnImage;
	}
	
	//TODO  the overlay Image only centers for now,  allow it to make dimensions where ever, such as
	//  bottom cornor, top cornor,....
	public static BufferedImage overlayImages(BufferedImage backgroundImage,BufferedImage centeredImage){
		// If the centered Image is any Dimension larger than the background image, it will throw a exception
		if (backgroundImage.getHeight()< centeredImage.getHeight() ||
				backgroundImage.getWidth() < centeredImage.getWidth()){
			try {
				throw new IOException("the centered Image is to Large,  it needs to be smaller than the backGround");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Point center = getCenterPoint(backgroundImage,centeredImage);
		Graphics2D g = backgroundImage.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(centeredImage, center.getX(), center.getY(), null);
		g.dispose();
		return backgroundImage;
	}
	
	public static Point getCenterPoint(BufferedImage backImage,BufferedImage centeredImage){
		int x,y;
		x = backImage.getWidth()/2;
		y = backImage.getHeight()/2;
		Point centerBack = new Point(x,y);
		x = centeredImage.getWidth()/2;
		y = centeredImage.getHeight()/2;
		Point centerImagePoint = new Point(centerBack.getX()-x,centerBack.getY()-y);
		return centerImagePoint;
	}
}
