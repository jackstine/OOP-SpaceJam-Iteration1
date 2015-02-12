package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MapViewController;
import model.Avatar;
import model.GameMap;
import model.Inventory;
import model.Location;
import model.Point;
import model.Weapon;
import view.InventoryView;

public class TileToInventoryTest extends JPanel {
	GameMap map;
	static JFrame frame;
	
	public TileToInventoryTest(){
		setSize(new Dimension(800,600));
		setPreferredSize(new Dimension(700, 700));
		setBackground(Color.BLACK);
		Weapon item = new Weapon(4);
		map= new GameMap(item);				// putting the item into the game map generates a map with the items
	}
	
	public static void setUpFrame(JFrame f, InventoryView inventoryView,TileToInventoryTest map){
		f.add(inventoryView);
		f.add(map);
		inventoryView.repaint();
        f.pack();
        f.repaint();
        f.setVisible(true);
	}
	
	public static void main(String[] args){
		
        JFrame f = new JFrame("Item on Tile to Inventory Test");
        f.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
        });
		Inventory inventory = new Inventory();
		InventoryView inventoryView = new InventoryView(inventory);
		TileToInventoryTest gameMap = new TileToInventoryTest();
		
		setUpFrame(f,inventoryView,gameMap);
	}	
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		map.draw(g);
		g.dispose();
		repaint();
	}
}
