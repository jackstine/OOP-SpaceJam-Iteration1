package utilities;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

import model.Point;

public class ImageProcessing {

	// resizes the image to the width and Height of the image
	public static BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
	    BufferedImage bi = null;
	    try {
	        ImageIcon ii = new ImageIcon(filename);//path to image
	        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) bi.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return bi;
	}
	
	//TODO  the overlay Image only centers for now,  allow it to make dimensions where ever, such as
	//  bottom cornor, top cornor,....
	public static BufferedImage overlayImages(BufferedImage backgroundImage,BufferedImage centeredImage) throws IOException{
		// If the centered Image is any Dimension larger than the background image, it will throw a exception
		if (backgroundImage.getHeight()< centeredImage.getHeight() ||
				backgroundImage.getWidth() < centeredImage.getWidth()){
			throw new IOException("the centered Image is to Large,  it needs to be smaller than the backGround");
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
