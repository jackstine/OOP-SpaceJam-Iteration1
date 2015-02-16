package view;

import java.awt.Dimension;
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

	private Avatar avatar;
	private final int MIDDLE=Scaling.ENTITY_MIDDLE;
	
	public EntityView(Avatar avatar) {
		this.avatar = avatar;
	}
	
	public void paintComponent(Graphics g){
		BufferedImage image = avatar.getImage();
		System.out.println("painting the entity");
		g.drawImage(image,0 ,0 , null);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(Scaling.TILE_WIDTH,Scaling.TILE_HEIGHT);
	}

}