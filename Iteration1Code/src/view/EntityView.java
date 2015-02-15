package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;




import javax.swing.JComponent;

import utilities.Scaling;
import model.Avatar;
import model.Entity;

/*

EntityView Class
Contains an instance of an Entity to be rendered as part of a Tile

*/

public class EntityView extends JComponent{
	private BufferedImage image;

	private Avatar avatar;
	private final int MIDDLE=Scaling.ENTITY_MIDDLE;
	
	public EntityView(Avatar avatar) {
		this.avatar = avatar;
		image= avatar.getImage();
		
	}
	
	public void paintComponent(Graphics g){
		image = avatar.getImage();
		g.drawImage(image, Scaling.ENTITY_MIDDLE ,Scaling.ENTITY_MIDDLE , null);
		g.dispose();
		//repaint();
	}

}