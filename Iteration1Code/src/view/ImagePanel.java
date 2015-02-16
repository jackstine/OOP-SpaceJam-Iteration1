package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

  private Image img;
  private JButton test;
  
  public ImagePanel(String img) {
	try {
		this.img = getToolkit().createImage(img);
	} catch (Exception e) { System.out.println("heyooo"); }
    System.out.println(this.img);
    
    setLayout(new BorderLayout());
    
    //test = new JButton("Hello!");
    //add(test, BorderLayout.CENTER);
    
    //revalidate();
    //repaint();
    //System.out.println(2);
  }

  public void paintComponent(Graphics g) {
	//System.out.println("PRINTED");
    g.drawImage(img, 0, 0, this);
  }

}