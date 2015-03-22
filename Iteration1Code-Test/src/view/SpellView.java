package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.mouse.SpellMouseHandler;
import utilities.ImageProcessing;
import utilities.Scaling;
import model.Point;
import model.entity.Avatar;

@SuppressWarnings("serial")
public class SpellView extends AbilityView{
	//**********************  POINTS **************************************
	private static final Point FIRE_SPELL_POINT = new Point(Scaling.FIRE_SPELL_X,Scaling.FIRE_SPELL_Y);
	private static final Point EARTH_SPELL_POINT = new Point(Scaling.EARTH_SPELL_X,Scaling.EARTH_SPELL_Y);
	private static final Point PLASMA_RAY_POINT = new Point(Scaling.PLASMA_RAY_X,Scaling.PLASMA_RAY_Y);
	private static final Point PACIFISM_POINT = new Point(Scaling.PACIFISM_X,Scaling.PACIFISM_Y);
	private static final Point CONFUSE_POINT = new Point(Scaling.CONFUSE_X,Scaling.CONFUSE_Y);
	private static final Point ANGRY_POINT = new Point(Scaling.ANGRY_X,Scaling.ANGRY_Y);
	private static final Point GLORY_HEAL_POINT = new Point(Scaling.GLORY_HEAL_X,Scaling.GLORY_HEAL_Y);
	private static final Point MANA_BUFF_POINT = new Point(Scaling.MANA_BUFF_X,Scaling.MANA_BUFF_Y);
	private static final Point MAGIC_CIRCLE_POINT = new Point(Scaling.MAGIC_CIRCLE_X,Scaling.MAGIC_CIRCLE_Y);
	//**********************  IMAGE PATHS *******************************
	private static final String FIRE_SPELL_PATH = "src/res/img/fireSpell.png";
	private static final String EARTH_SPELL_PATH = "src/res/img/earthSpell.png"; 
	private static final String PLASMA_RAY_PATH = "src/res/img/plasmaRay.png";
	private static final String PACIFISM_PATH = "src/res/img/pacifism.png";
	private static final String CONFUSE_PATH = "src/res/img/confuse.png";
	private static final String ANGRY_PATH = "src/res/img/angry.png";
	private static final String GLORY_HEAL_PATH = "src/res/img/gloryHeal.png";
	private static final String MANA_BUFF_PATH = "src/res/img/manaBuff.png";
	private static final String MAGIC_CIRCLE_PATH = "src/res/img/magicCircle.png";

	private static final Point SPELL_SLOT = new Point(Scaling.SPELL_WIDTH,Scaling.SPELL_HEIGHT);
	
	//********************** IMAGES *************************************************
	private static final BufferedImage FIRE_SPELL_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,FIRE_SPELL_PATH);
	private static final BufferedImage EARTH_SPELL_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,EARTH_SPELL_PATH);
	private static final BufferedImage PLASMA_RAY_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,PLASMA_RAY_PATH);
	private static final BufferedImage PACIFISM_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,PACIFISM_PATH);
	private static final BufferedImage CONFUSE_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,CONFUSE_PATH);
	private static final BufferedImage ANGRY_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,ANGRY_PATH);
	private static final BufferedImage GLORY_HEAL_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,GLORY_HEAL_PATH);
	private static final BufferedImage MANA_BUFF_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,MANA_BUFF_PATH);
	private static final BufferedImage MAGIC_CIRCLE_IMAGE = ImageProcessing.scaleImage(SPELL_SLOT,MAGIC_CIRCLE_PATH);
	 
	private final Point SELECTED_SPELL_SCALE = new Point(40,40);
	private final int SELECTED_SPELL_X_OFFSET = 5;
	private Avatar avatar;
	private SpellMouseHandler handler;

	public SpellView(Avatar avatar){
		super(avatar);
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(FIRE_SPELL_IMAGE, FIRE_SPELL_POINT.getX(), FIRE_SPELL_POINT.getY(), null);
		g.drawImage(EARTH_SPELL_IMAGE, EARTH_SPELL_POINT.getX(), EARTH_SPELL_POINT.getY(), null);
		g.drawImage(PLASMA_RAY_IMAGE, PLASMA_RAY_POINT.getX(), PLASMA_RAY_POINT.getY(), null);
		g.drawImage(PACIFISM_IMAGE, PACIFISM_POINT.getX(), PACIFISM_POINT.getY(), null);
		g.drawImage(CONFUSE_IMAGE, CONFUSE_POINT.getX(), CONFUSE_POINT.getY(), null);
		g.drawImage(ANGRY_IMAGE, ANGRY_POINT.getX(), ANGRY_POINT.getY(), null);
		g.drawImage(GLORY_HEAL_IMAGE, GLORY_HEAL_POINT.getX(), GLORY_HEAL_POINT.getY(), null);
		g.drawImage(MANA_BUFF_IMAGE, MANA_BUFF_POINT.getX(), MANA_BUFF_POINT.getY(), null);
		g.drawImage(MAGIC_CIRCLE_IMAGE, MAGIC_CIRCLE_POINT.getX(), MAGIC_CIRCLE_POINT.getY(), null);
	}

	public Dimension getPreferredSize(){
		return new Dimension(150,300);
	}
	
	public int getYRange(){
		return super.getYRange() + Scaling.SPELLS_HEIGHT_NUM;
	}
}
