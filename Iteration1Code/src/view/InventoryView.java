package view;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Inventory;
import model.InventorySlot;
import model.Point;
import model.Weapon;

public class InventoryView extends JPanel{
	private SlotView[][] slots = new SlotView[Inventory.ROW][Inventory.COL];
	private Inventory inventory;
	
	InventoryView(Inventory inventory){
		this.inventory = inventory;
		this.setInventoryView();
	}
	
	private void setInventoryView(){ 
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				System.out.println(this.inventory.get(new Point(i,j)));
				Point pointOfSlot = new Point(i,j);
				this.slots[i][j] = new SlotView( this.inventory.getSlot(pointOfSlot) , pointOfSlot );
				this.slots[i][j].resetImage();					//TODO make this function automatic
			}
		}
	}
	
	public void paint(Graphics g){
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				this.slots[i][j].paint(g);
			}
		}
	}
	
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
				if (j%2==0){
					inventory.equip(new Point(i,j), new Weapon(5));
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
