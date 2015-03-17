package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

  private Image img;
  //private JButton test;
  
  public ImagePanel(String img) {
	try {
		this.img = getToolkit().createImage(img);
	} catch (Exception e) { System.out.println("heyooo"); }
    System.out.println(this.img);
    
    setLayout(new BorderLayout());
  }

  public void paintComponent(Graphics g) {
	//System.out.println("PRINTED");
    g.drawImage(img, 0, 0, this);
  }

}