package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utilities.Scaling;
import model.Avatar;
import model.GameMap;
import model.Item;
import model.Location;

public class GameView extends JPanel {
	GameMap map;
	Avatar avatar;
	EntityView entityView;
	BufferedImage image;
	MapView mapView;

	public GameView(){
		map = new GameMap();
		avatar = new Avatar();
		entityView=new EntityView(avatar);
		//image=avatar.getImage();
		setFocusable(true);
		setPreferredSize(new Dimension(Scaling.GAME_VIEW_WIDTH, Scaling.GAME_VIEW_HEIGHT));
		setBackground(Color.BLACK);
		map.updateEntityLocation(avatar, new Location(3,3));			//TODO NO MAGIC NUMBERS PLEASE
		image=avatar.getImage();
		setVisible(true);
	}
	
	public GameView(GameMap map, Avatar avatar){
		this.map = map;
		this.avatar = avatar;
		entityView=new EntityView(avatar);
		MapView mapView= new MapView(avatar);
		//image=avatar.getImage();
		setFocusable(true);
		setPreferredSize(new Dimension(Scaling.GAME_VIEW_WIDTH, Scaling.GAME_VIEW_HEIGHT));
		setBackground(Color.BLACK);
		this.map.updateEntityLocation(avatar, new Location(3,3));
		image=avatar.getImage();
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		map.draw(g);
		entityView.draw(g);
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
