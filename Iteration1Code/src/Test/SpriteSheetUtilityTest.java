package Test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utilities.SpriteSheetUtility;

public class SpriteSheetUtilityTest {
	public static void main(String[] args) {
		displayImage();
	}
	
	public static void displayImage() {
		//MERELY FOR TESTING PURPOSES DON"T USE FOR ANYTHING REAL!!!!
		BufferedImage[] b = (new SpriteSheetUtility(SpriteSheetUtility.HUNTER).getSpriteArray());
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		JLabel label;
		for (int i=0; i < 10; i++) {
			label = new JLabel(new ImageIcon(b[i]));
			label.setBorder(BorderFactory.createLineBorder(Color.black));
			frame.getContentPane().add(label);
		}

		frame.pack();
		frame.setVisible(true);
	}
	
}
