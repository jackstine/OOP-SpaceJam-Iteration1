package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import controller.mouse.AbilityMouseHandler;
import controller.mouse.SpellMouseHandler;
import utilities.ImageProcessing;
import utilities.Scaling;
import model.Point;
import model.entity.Avatar;
import model.entity.Entity;

@SuppressWarnings("serial")
public class AbilityView extends JComponent{
	//**********************  POINTS **************************************
	private static final Point OBSERVATION_POINT = new Point(Scaling.OBSERVATION_X,Scaling.OBSERVATION_Y);
	private static final Point BIND_WOUNDS_POINT = new Point(Scaling.BIND_WOUNDS_X,Scaling.BIND_WOUNDS_Y);

	//**********************  IMAGE PATHS *******************************
	private static final String OBSERVATION_PATH = "src/res/img/Observation.png";
	private static final String BIND_WOUNDS_PATH = "src/res/img/Bandage.png"; 


	private static final Point ABILITY_SLOT = new Point(Scaling.SPELL_WIDTH,Scaling.SPELL_HEIGHT);
	
	//********************** IMAGES *************************************************
	private static final BufferedImage OBSERVATION_IMAGE = ImageProcessing.scaleImage(ABILITY_SLOT, OBSERVATION_PATH);
	private static final BufferedImage BIND_WOUNDS_IMAGE = ImageProcessing.scaleImage(ABILITY_SLOT, BIND_WOUNDS_PATH);

	 
	private final Point SELECTED_ABILITY_SCALE = new Point(40,40);
	private final int SELECTED_ABILITY_X_OFFSET = 5;
	private Entity avatar;
	private AbilityMouseHandler handler;

	public AbilityView(){
		this.avatar = avatar;
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.addMouseListener(new SpellListener());
	}
	
	public AbilityView(Entity avatar){
		this.avatar = avatar;
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.addMouseListener(new SpellListener());
		this.avatar = avatar;
		this.handler = new AbilityMouseHandler(this,this.avatar);
	}
	
	private void paintSelectedSpell(Graphics g){
		if (handler.getSelected() != null){
			g.setColor(Color.YELLOW);
			int pointX = (handler.getSelected().getX() * Scaling.SPELL_SPACE_X) + SELECTED_ABILITY_X_OFFSET;
			int pointY = (handler.getSelected().getY() * Scaling.SPELL_SPACE_Y);
			g.fillRect(pointX, pointY, SELECTED_ABILITY_SCALE.getX(), SELECTED_ABILITY_SCALE.getY());
		}
	}
	
	public void paint(Graphics g){
		this.paintSelectedSpell(g);
		g.drawImage(OBSERVATION_IMAGE, OBSERVATION_POINT.getX(), OBSERVATION_POINT.getY(), null);
		g.drawImage(BIND_WOUNDS_IMAGE, BIND_WOUNDS_POINT.getX(), BIND_WOUNDS_POINT.getY(), null);

	}

	public Dimension getPreferredSize(){
		return new Dimension(150,300);
	}
	
	public int getYRange(){
		return Scaling.ABILITIES_HEIGHT_NUM;
	}
	
	public void setEntity(Entity entity){
		this.avatar = entity;
		this.handler = new AbilityMouseHandler(this,this.avatar);
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
