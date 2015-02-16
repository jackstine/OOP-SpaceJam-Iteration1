package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

import javax.swing.JPanel;

import controller.ViewController.RunGameTimer;

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
	public static final int STARTINGX=3;
	public static final int STARTINGY=3;
	
	public GameView(GameMap map, Avatar avatar){
		this.map = map;
		this.avatar = avatar;
		entityView=new EntityView(avatar);
		this.mapView= new MapView(this.map,entityView,avatar);
		add(this.mapView);
		setView();
		this.map.updateEntityLocation(avatar, new Location(3,3)); //NOT NEEDED ANYMORE
		image=avatar.getImage();
	}
	
	public MapView getMapView(){
		return this.mapView;
	}
	
	public GameView(GameMap map, Avatar avatar, Location location){
		this.map = map;
		this.avatar = avatar;
		entityView=new EntityView(avatar);
		 this.mapView= new MapView(this.map,entityView,avatar);
		add(this.mapView);
		setView();
		this.map.updateEntityLocation(avatar, location);// NOT NEEDED ANYMORE
		image=avatar.getImage();
	}
	
	private void setView(){
        setFocusable(true);
        setPreferredSize(new Dimension(Scaling.GAME_VIEW_WIDTH, Scaling.GAME_VIEW_HEIGHT));
        setBackground(Color.BLACK);
        setVisible(true);
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
	
	public class mapMakerDelay implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
