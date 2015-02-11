package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Inventory;
import model.Point;
import model.Weapon;

public class InventoryView extends JPanel{
	public static final int INVENTORY_HEIGHT = Inventory.ROW *SlotView.SLOTIMAGE_HEIGHT;
	public static final int INVENTORY_WIDTH = Inventory.COL * SlotView.SLOTIMAGE_WIDTH;
	
	private SlotView[][] slots = new SlotView[Inventory.ROW][Inventory.COL];
	private Inventory inventory;
	
	private static final long serialVersionUID = 17481L;
	
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
																//TODO make InventorySLot be a Observable
			}
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(INVENTORY_HEIGHT, INVENTORY_WIDTH);
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
				if (j%2==0){	// just make every other a weapon
					Point point = new Point(i,j);
					inventory.equip( point , new Weapon(5));
					System.out.println(point);
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
