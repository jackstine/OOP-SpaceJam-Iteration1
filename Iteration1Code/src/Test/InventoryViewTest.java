package Test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import model.Inventory;
import model.Point;
import model.Weapon;
import view.InventoryView;

public class InventoryViewTest {
	public static void main(String[] args){
        JFrame f = new JFrame("Load Image Sample");
        f.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
        });
		Inventory inventory = new Inventory();
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				if (j%2==0){	// just make every other a weapon
					Point point = new Point(i,j);
					inventory.equip( point , new Weapon(5));
				}
			}
		}
		
		InventoryView inventoryView = new InventoryView(inventory);
		
		f.add(inventoryView);	
		f.repaint();
        f.pack();
        f.setVisible(true);
	}
}
