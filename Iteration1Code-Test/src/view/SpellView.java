package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.Point;

@SuppressWarnings("serial")
public class SpellView extends JComponent{
	//**********************  POINTS **************************************
	private static final Point FIRE_SPELL_POINT = new Point(0,0);
	//**********************  IMAGE PATHS *******************************
	private static final String FIRE_SPELL_PATH = "src/res/img/fireSpell.png";
	//********************** IMAGES *************************************************
	private static final BufferedImage FIRE_SPELL_IMAGE = ImageProcessing.scaleImage(new Point(50,50),FIRE_SPELL_PATH);
	
	public SpellView(){
		setFocusable(true);
		setBackground(Color.BLACK);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		System.out.println("Painting the spell *********************************");
		g.drawImage(FIRE_SPELL_IMAGE, FIRE_SPELL_POINT.getX(), FIRE_SPELL_POINT.getY(), null);
	}

	public Dimension getPreferredSize(){
		return new Dimension(80,80);
	}
}
