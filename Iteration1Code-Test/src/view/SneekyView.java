package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.Scaling;
import model.Point;
import model.entity.Avatar;

@SuppressWarnings("serial")
public class SneekyView extends AbilityView{
	//**********************  POINTS **************************************
		private static final Point SNEAK_POINT = new Point(Scaling.SNEAK_X,Scaling.SNEAK_Y);
		private static final Point RANGE_ATTACK_POINT = new Point(Scaling.RANGE_ATTACK_X, Scaling.RANGE_ATTACK_Y);
		
		//**********************  IMAGE PATHS *******************************
		private static final String SNEAK_PATH = "src/res/img/Sneak.png";
		private static final String RANGE_ATTACK_PATH = "src/res/img/Range.png";
		private static final Point SPELL_SLOT = new Point(Scaling.SPELL_WIDTH,Scaling.SPELL_HEIGHT);
		
		//********************** IMAGES *************************************************
		private static final BufferedImage SNEAK_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,SNEAK_PATH);
		private static final BufferedImage RANGE_ATTACK_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,RANGE_ATTACK_PATH);

		 
		private final Point SELECTED_SPELL_SCALE = new Point(40,40);
		private final int SELECTED_SPELL_X_OFFSET = 5;
		

		public SneekyView(){}
		
		public SneekyView(Avatar avatar) {
			super(avatar);
		}
		
		public void paint(Graphics g){
			super.paint(g);
			g.drawImage(SNEAK_IMAGE, SNEAK_POINT.getX(), SNEAK_POINT.getY(), null);
			g.drawImage(RANGE_ATTACK_IMAGE, RANGE_ATTACK_POINT.getX(), RANGE_ATTACK_POINT.getY(), null);
		}

		public Dimension getPreferredSize(){
			return new Dimension(150,300);
		}
		
		public int getYRange(){
			return super.getYRange() + Scaling.SPELLS_HEIGHT_NUM;
		}
}
