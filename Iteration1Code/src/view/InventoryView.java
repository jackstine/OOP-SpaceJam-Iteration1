package view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.Inventory;
import model.Point;

public class InventoryView extends JPanel{
	public static final int INVENTORY_HEIGHT = Inventory.COL * SlotView.SLOTIMAGE_HEIGHT;
	public static final int INVENTORY_WIDTH = Inventory.ROW * SlotView.SLOTIMAGE_WIDTH;
	
	private SlotView[][] slots = new SlotView[Inventory.ROW][Inventory.COL];
	private Inventory inventory;
	
	private static final long serialVersionUID = 17481L;
	
	public InventoryView(Inventory inventory){
		this.inventory = inventory;
		this.setInventoryView();
	}
	
	private void setInventoryView(){ 
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
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

}
