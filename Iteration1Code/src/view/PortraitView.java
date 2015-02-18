package view;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class PortraitView extends JPanel{
	
	//the height of every portrait image is 168px
	//ideally the height of the status bar will be 200px
	//giving even amount of blank space on either side (top or bottom) of the portrait
	//we want to set the top-right corner of the portrait at a y-value of 16
	private final int MAGIC_Y_OFFSET = 7;
	private final int MAGIC_X_OFFSET = 10;
	
	private BufferedImage image;
	
	public PortraitView(BufferedImage image) {
		this.image = image;
		repaint();
	}
	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, MAGIC_X_OFFSET, MAGIC_Y_OFFSET, this);
    }
}
