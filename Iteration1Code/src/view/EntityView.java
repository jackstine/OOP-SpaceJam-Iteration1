package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import model.Avatar;
import model.Entity;

/*

EntityView Class
Contains an instance of an Entity to be rendered as part of a Tile

*/

public class EntityView {
	private BufferedImage image;

	private Avatar avatar;
	private final int MIDDLE=300;
	
	public EntityView(Avatar avatar) {
		this.avatar = avatar;
		image= avatar.getImage();
		
	}
	
	public void draw(Graphics g){
		g.drawImage(image,MIDDLE,MIDDLE,null);
		g.dispose();
		//repaint();
	}

}