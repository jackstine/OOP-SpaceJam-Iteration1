package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import utilities.Scaling;
import model.Point;
import model.slots.Inventory;

public class InventoryView extends JComponent{
	private static final int INVENTORY_HEIGHT = Inventory.ROW * Scaling.SLOT_VIEW_HEIGHT;
	private static final int INVENTORY_WIDTH = Inventory.COL * Scaling.SLOT_VIEW_WIDTH;
	
	private SlotView[][] slots = new SlotView[Inventory.ROW][Inventory.COL];
	private Inventory inventory;
	
	private static final long serialVersionUID = 17481L;
	
	public InventoryView(Inventory inventory){
		this.inventory = inventory;
		this.setInventoryView();
		setFocusable(true);
		setBackground(Color.BLACK);
		setVisible(true);
	}
	
	private void setInventoryView(){ 
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				// We need to add the SlotView to the Inventory SLot as a Observer
				// as well as make the slotView point to the slot
				Point pointOfSlot = new Point(i,j);
				this.slots[i][j] = new SlotView( this.inventory.getSlot(pointOfSlot) , pointOfSlot);
				this.slots[i][j].resetImage();
				this.inventory.getSlot(pointOfSlot).addObserver(this.slots[i][j]);
				//Delete for Testing Only
			}
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(INVENTORY_WIDTH,INVENTORY_HEIGHT);
	}
	
	public void paint(Graphics g){
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				this.slots[i][j].paintComponent(g);
			}
		}
		g.dispose();
		repaint();
	}
}
