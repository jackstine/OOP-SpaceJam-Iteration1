package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.Avatar;
import model.GameMap;
import model.Item;
import model.Location;
import model.Tile;

/*

MapView Class
Displays the specific subsection of the map as is relevant to the player

*/


public class MapView extends JPanel {
	GameMap map;
	Avatar avatar;
	//subset of map to display
	//private TileView[][] grid;
	
	public MapView(Avatar avatar) {
		map= new GameMap();
		this.avatar=avatar;
		//this.addMouseListener(new MapMouseListener());
	}
	
	//protected void paintComponent(Graphics g) {}
	/*
	public class MapMouseListener implements MouseListener{


		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			int tileY = e.getY()/Tile.SCALE;
			int tileX = e.getX()/Tile.SCALE;
			Location tileLocation = new Location(tileX,tileY);
			
			//TRANSACTION   USE get ,  if room in Inventory  then drop,  else do nothing
			Item droppedItem = map.getTile(tileLocation).getItem();
			System.out.println(droppedItem+"  "+tileLocation);
			if (inventoryView.getInventory().findAndEquip(droppedItem)){
				map.getTile(tileLocation).dropItem();
				tile.repaint();
				frame.repaint();
			}
			tile.repaint();
			this.repaint();
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	*/
	
	public void draw(Graphics g){
		Location location= map.getLocation(avatar);
		int lowX=location.getX()-3;
		int highX=location.getX()+3;
		int lowY=location.getY()-3;
		int highY=location.getY()+3;
		for(int i=lowX;i<=highX;i++){
			for(int j=lowY;j<=highY;j++){
				map.getTile(new Location(i,j)).draw(g);
			}
		}
	}
	
	
	
}