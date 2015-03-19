package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utilities.Scaling;
import model.Point;
import model.slots.Inventory;
import model.slots.InventorySlot;
import model.visitor.ItemImageVisitor;

@SuppressWarnings("serial")
public class InventoryView extends JComponent{
	private static final int INVENTORY_HEIGHT = Inventory.ROW * Scaling.SLOT_VIEW_HEIGHT;
	private static final int INVENTORY_WIDTH = Inventory.COL * Scaling.SLOT_VIEW_WIDTH;
	
	private SlotView[][] slots = new SlotView[Inventory.ROW][Inventory.COL];
	private Inventory inventory;
	private InventorySlot draggingSlot = new InventorySlot();
	private Point draggingSlotPoint;
	private BufferedImage draggingImage;
	
	private static ItemImageVisitor itemVisitor = new ItemImageVisitor(new Point(Scaling.SLOT_VIEW_WIDTH,Scaling.SLOT_VIEW_HEIGHT));
	
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
		this.paintDraggingSlot(g);
		
		g.dispose();
		repaint();
	}
	
	public void paintDraggingSlot(Graphics g){
		if (this.draggingSlot.has()){
			this.draggingSlot.get().accept(itemVisitor);
			this.draggingImage = itemVisitor.getImage();
			g.drawImage(draggingImage, draggingSlotPoint.getX(), draggingSlotPoint.getY(),null);
		}
	}
	
	public void setDraggingSlot(InventorySlot slot){
		this.draggingSlot = slot;
	}
	
	public void setDraggingSlotPoint(Point point){
		this.draggingSlotPoint = point;
	}
}
