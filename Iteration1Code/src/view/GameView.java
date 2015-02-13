package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Avatar;
import model.GameMap;
import model.Location;
import controller.MapViewController;

public class GameView extends JPanel {
	GameMap map = new GameMap();
	Avatar avatar = new Avatar();
	BufferedImage image=avatar.getImage();
	
	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public GameView(){
		setFocusable(true);
		setPreferredSize(new Dimension(700, 700));
		setBackground(Color.BLACK);
		map.updateEntityLocation(avatar, new Location(3,3));
		image=avatar.getImage();
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		int x= map.getLocation(avatar).getX();
		int y=map.getLocation(avatar).getY();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		map.draw(g);
		g.drawImage(image,100*x,100*y,null);
		g.dispose();
		repaint();
	}
}
