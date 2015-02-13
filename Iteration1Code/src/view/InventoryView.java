package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Inventory;
import model.Item;
import model.Point;

public class InventoryView extends JPanel{
	// AHHAHAHAHAHAHA   CONNASCENCE    =)
	public static final int INVENTORY_HEIGHT = Inventory.ROW * SlotView.SLOTIMAGE_HEIGHT;
	public static final int INVENTORY_WIDTH = Inventory.COL * SlotView.SLOTIMAGE_WIDTH;
	private Point pointOnView;
	
	//TODO unchecked provision stuffies
	@SuppressWarnings("unchecked")
	private SlotView<Item>[][] slots = new SlotView[Inventory.ROW][Inventory.COL];
	private Inventory inventory;
	
	private static final long serialVersionUID = 17481L;
	
	public InventoryView(Inventory inventory,Point pointOnView){
		this.inventory = inventory;
		this.pointOnView = pointOnView;
		this.setInventoryView();
	}
	
	private void setInventoryView(){ 
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				// We need to add the SlotView to the Inventory SLot as a Observer
				// as well as make the slotView point to the slot
				Point pointOfSlot = new Point(i,j);
				this.slots[i][j] = new SlotView<Item>( this.inventory.getSlot(pointOfSlot) , pointOfSlot, this.pointOnView );
				this.inventory.getSlot(pointOfSlot).addObserver(this.slots[i][j]);
				
			}
		}
	}
	
	
	public Inventory getInventory(){
		return this.inventory;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(INVENTORY_WIDTH,INVENTORY_HEIGHT);
	}
	
	public void paint(Graphics g){
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				this.slots[i][j].paint(g);
			}
		}
	}
	
	public void setPointOnView(Point point){
		this.pointOnView = point;
	}
	
	public Point getPointOnView(Point point){
		return this.pointOnView;
	}
}
