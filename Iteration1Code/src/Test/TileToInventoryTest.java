package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameMap;
import model.Inventory;
import model.Item;
import model.Location;
import model.Point;
import model.Tile;
import model.Weapon;
import view.InventoryView;

public class TileToInventoryTest extends JPanel {
	GameMap map;
	static JFrame frame;
	InventoryView inventoryView;
	TileToInventoryTest tile;
	
	public TileToInventoryTest(JFrame frame){
		this.tile = this;
		this.frame = frame;
		setSize(new Dimension(1400,800));
		setPreferredSize(new Dimension(1400, 800));
		setBackground(Color.BLACK);
		Weapon item = new Weapon(4);
		map= new GameMap(item);				// putting the item into the game map generates a map with the items
		Inventory inventory = new Inventory();
		//its zero because we want to put the inventory in the top right of the map
		Point pointOfInventory = new Point(map.getWidth(),0);
		System.out.println(map.getWidth() +"    " + map.getHeight());
		this.inventoryView = new InventoryView(inventory,pointOfInventory);
		this.addMouseListener(new InventoryListener());
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
		TileToInventoryTest gameMapWithItemsInventory = new TileToInventoryTest(f);
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
	
	public class InventoryListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			//TODO
			//Fix this...what is Tile.SCALE?
			//int tileY = e.getY()/Tile.SCALE;
			//int tileX = e.getX()/Tile.SCALE;
			
			//delete these placeholders
			int tileY = 0;
			int tileX = 0;
			
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
			frame.repaint();
		}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		
	}
}
