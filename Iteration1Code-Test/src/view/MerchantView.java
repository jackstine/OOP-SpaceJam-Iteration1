package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import utilities.Scaling;
import view.InventoryView;
import model.Point;
import model.entity.Avatar;
import model.entity.Entity;
import model.items.TakeableItem;
import model.slots.Inventory;

@SuppressWarnings("serial")
public class MerchantView extends JFrame{
//public class MerchantView extends JComponent{	
private Inventory inventory;
private InventoryView inventoryView;
private Entity entity;

public MerchantView()
{	
	super("Merchant");
	inventory=new Inventory();
	inventoryView=new InventoryView(inventory);
	inventoryView.addMouseListener(new MerchantMouseListener());
	add(inventoryView,BorderLayout.CENTER);
	setVisible(false);
	
	}

public void showMerchantView()
{
	
	this.setVisible(true);
	this.requestFocus();
	//this.moveToFront(inventoryView);
}

public void setEntity(Entity entity)
{
	this.entity=entity;
	
}
	
	public class MerchantMouseListener implements MouseListener
	{
		private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;

		private Point getInventorySlot(MouseEvent e){
			int x = e.getY()/Scaling.SLOT_VIEW_SCALE;
			int y = e.getX()/Scaling.SLOT_VIEW_SCALE;
			return new Point(x,y);
		}
		
		private void unequipItem(MouseEvent e){
			Point slotPoint = getInventorySlot(e);
			TakeableItem item=inventory.get(slotPoint);
			inventory.unequip(slotPoint);
			entity.getInventory().findAndEquip(item);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getButton() == RIGHT_CLICK){
				this.unequipItem(e);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
