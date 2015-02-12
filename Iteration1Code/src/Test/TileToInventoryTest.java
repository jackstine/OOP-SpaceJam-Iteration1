package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameMap;
import model.Inventory;
import model.Point;
import model.Weapon;
import view.InventoryView;

public class TileToInventoryTest extends JPanel {
	GameMap map;
	static JFrame frame;
	InventoryView inventoryView;
	
	public TileToInventoryTest(){
		setSize(new Dimension(800,600));
		setPreferredSize(new Dimension(700, 700));
		setBackground(Color.BLACK);
		Weapon item = new Weapon(4);
		map= new GameMap(item);				// putting the item into the game map generates a map with the items
		Inventory inventory = new Inventory();
		//its zero because we want to put the inventory in the top right of the map
		Point pointOfInventory = new Point(map.getWidth(),0);
		System.out.println(map.getWidth() +"    " + map.getHeight());
		this.inventoryView = new InventoryView(inventory,pointOfInventory);
	}
	
	public static void setUpFrame(JFrame f,TileToInventoryTest map){
		f.add(map);
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
		TileToInventoryTest gameMapWithItemsInventory = new TileToInventoryTest();
		setUpFrame(f,gameMapWithItemsInventory);
	}	
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		map.draw(g);
		inventoryView.paint(g);
		g.dispose();
		repaint();
	}
}
