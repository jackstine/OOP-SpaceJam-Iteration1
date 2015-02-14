package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import utilities.Scaling;
import model.Inventory;
import model.Item;
import model.Point;
import model.Weapon;

public class InventoryView extends JPanel{
	// AHHAHAHAHAHAHA   CONNASCENCE    =)
	private static final int INVENTORY_HEIGHT = Inventory.ROW * Scaling.SLOT_VIEW_HEIGHT;
	private static final int INVENTORY_WIDTH = Inventory.COL * Scaling.SLOT_VIEW_WIDTH;
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
				this.slots[i][j] = new SlotView<Item>( this.inventory.getSlot(pointOfSlot) , pointOfSlot, this.pointOnView );
				this.inventory.getSlot(pointOfSlot).addObserver(this.slots[i][j]);
				
				//Delete for Testing Only
				this.inventory.getSlot(pointOfSlot).equip(new Weapon(10));
			}
		}
		this.addMouseListener(new InventoryMouseListener());
	}
	
	
	public Inventory getInventory(){
		return this.inventory;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(INVENTORY_WIDTH,INVENTORY_HEIGHT);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(this.pointOnView.getX(),this.pointOnView.getY(),getWidth(),getHeight());
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				this.slots[i][j].paintComponent(g);
			}
		}
		g.dispose();
		repaint();
	}
	
	public void setPointOnView(Point point){
		this.pointOnView = point;
	}
	
	public Point getPointOnView(Point point){
		return this.pointOnView;
	}
	
	
	
	public class InventoryMouseListener implements MouseListener{
		private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;

		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			int x = e.getY()/Scaling.SLOT_VIEW_SCALE;
			int y = e.getX()/Scaling.SLOT_VIEW_SCALE;
			if (e.getButton() == RIGHT_CLICK){
				Point slotPoint = new Point(x,y);
				inventory.getSlot(slotPoint).unequip();
				System.out.println(slotPoint);
			}
			if (e.getButton()== LEFT_CLICK){
				System.out.println("Equip ("+x+","+y+")");
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	
}
