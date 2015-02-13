package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Avatar;
import model.GameMap;
import model.Location;

public class GameView extends JPanel {
	GameMap map;
	Avatar avatar;
	BufferedImage image;

	public GameView(){
		map = new GameMap();
		avatar = new Avatar();
		image=avatar.getImage();
		setFocusable(true);
		setPreferredSize(new Dimension(700, 700));
		setBackground(Color.BLACK);
		map.updateEntityLocation(avatar, new Location(3,3));
		image=avatar.getImage();
		setVisible(true);
	}
	
	public GameView(GameMap map, Avatar avatar){
		this.map = map;
		this.avatar = avatar;
		image=avatar.getImage();
		setFocusable(true);
		setPreferredSize(new Dimension(700, 700));
		setBackground(Color.BLACK);
		this.map.updateEntityLocation(avatar, new Location(3,3));
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
}
