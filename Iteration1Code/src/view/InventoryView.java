package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Inventory;
import model.Item;
import model.Location;
import model.Point;
import model.Tile;

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
		for (int i = 0; i<Inventory.ROW ; i++){
			for (int j = 0; j<Inventory.COL;j++){
				this.slots[i][j].paint(g);
			}
		}
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		paint(g);
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


		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			
			System.out.println(e);
//			int tileY = e.getY()/Tile.SCALE;
//			int tileX = e.getX()/Tile.SCALE;
//			Location tileLocation = new Location(tileX,tileY);
//			
//			//TRANSACTION   USE get ,  if room in Inventory  then drop,  else do nothing
//			Item droppedItem = map.getTile(tileLocation).getItem();
//			System.out.println(droppedItem+"  "+tileLocation);
//			if (inventoryView.getInventory().findAndEquip(droppedItem)){
//				map.getTile(tileLocation).dropItem();
//				tile.repaint();
//				frame.repaint();
//			}
//			tile.repaint();
//			this.repaint();
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	
}
