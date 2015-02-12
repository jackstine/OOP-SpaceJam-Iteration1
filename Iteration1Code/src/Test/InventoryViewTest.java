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
		int TIME = 500;
		
        JFrame f = new JFrame("Load Image Sample");
        f.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent e) {
	            System.exit(0);
	        }
        });
		Inventory inventory = new Inventory();
		InventoryView inventoryView = new InventoryView(inventory);
		f.add(inventoryView);
		inventoryView.repaint();
        f.pack();
        f.repaint();
        f.setVisible(true);
		try {
			Thread.sleep(TIME);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				if (j%2==0){						// just make every other a weapon
					Point point = new Point(i,j);
					inventory.equip( point , new Weapon(i+j));
					System.out.println("Equipping a Weapon of "+(int)(i+j));
					f.repaint();
					try {
						Thread.sleep(TIME);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				Point point = new Point(i,j);
				inventory.unequip(point);
				f.repaint();
				try {
					Thread.sleep(TIME);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//end of for
		}//end of for
	}	
}
