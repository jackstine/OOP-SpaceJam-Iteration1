package Test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.Inventory;
import model.Point;
import model.Weapon;
import view.InventoryView;

public class TileToInventoryTest {
	
	public static void setUpFrame(JFrame f, InventoryView inventoryView){
		f.add(inventoryView);
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
		
		setUpFrame(f,inventoryView);
	}	
}
