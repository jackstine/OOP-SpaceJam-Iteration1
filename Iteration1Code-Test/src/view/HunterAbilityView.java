package view;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import controller.mouse.AbilityMouseHandler;
//import controller.mouse.SpellMouseHandler;
import utilities.ImageProcessing;
import utilities.Scaling;
import model.Point;
import model.entity.Avatar;

@SuppressWarnings("serial")
public class HunterAbilityView extends AbilityView{
	//**********************  POINTS **************************************
	private static final Point SNEAK_POINT = new Point(Scaling.SNEAK_X,Scaling.SNEAK_Y);
	private static final Point PICKPOCKET_POINT = new Point(Scaling.PICKPOCKET_X,Scaling.PICKPOCKET_Y);
	
	//**********************  IMAGE PATHS *******************************
	private static final String SNEAK_PATH = "src/res/img/Sneak.png";
	private static final String PICKPOCKET_PATH = "src/res/img/pickpocket.png";


	private static final Point SPELL_SLOT = new Point(Scaling.SPELL_WIDTH,Scaling.SPELL_HEIGHT);
	
	//********************** IMAGES *************************************************
	private static final BufferedImage SNEAK_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,SNEAK_PATH);
	private static final BufferedImage PICKPOCKET_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,PICKPOCKET_PATH);

	 
	private final Point SELECTED_SPELL_SCALE = new Point(40,40);
	private final int SELECTED_SPELL_X_OFFSET = 5;
	private Avatar avatar;
	private AbilityMouseHandler handler;

	public HunterAbilityView(Avatar avatar){
		super(avatar);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(SNEAK_IMAGE, SNEAK_POINT.getX(), SNEAK_POINT.getY(), null);
		g.drawImage(PICKPOCKET_IMAGE, PICKPOCKET_POINT.getX(), PICKPOCKET_POINT.getY(), null);
	}

	public Dimension getPreferredSize(){
		return new Dimension(150,300);
	}
	
	public class SpellListener implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			handler.selectSpell(e);
		}

		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}
	
}
