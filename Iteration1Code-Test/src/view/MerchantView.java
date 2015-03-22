package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import utilities.Scaling;
import view.InventoryView;
import model.GameLog;
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
private Entity reciever;
private int basePrice;

public MerchantView(Entity barter)
{	
	super("Merchant");
	this.entity = barter;
	inventory = barter.getInventory();
	inventoryView=new InventoryView(barter.getInventory());
	inventoryView.addMouseListener(new MerchantMouseListener());
	add(inventoryView,BorderLayout.CENTER);
	setVisible(false);	
	basePrice = 100;
	}

public void showMerchantView()
{
	
	this.setVisible(true);
	this.requestFocus();
	//this.moveToFront(inventoryView);
	this.setAlwaysOnTop(true);
	this.addWindowListener(new MerchantCloseOp());
}

public void setEntity(Entity entity)
{
	this.reciever=entity;
	
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
			reciever.getInventory().findAndEquip(item);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Point slotPoint = getInventorySlot(e);
			TakeableItem item=inventory.get(slotPoint);
			basePrice = item.getBonus();
			String transaction = "Price: " + (basePrice-(reciever.getSkillValue("Bargain")*2));
			//System.out.println("price of item: " + (basePrice-(reciever.getSkillValue("Bargain")*10)));
			if (e.getButton() == RIGHT_CLICK && reciever.getGold() >= basePrice-(reciever.getSkillValue("Bargain")*2)){
				reciever.makeGoldTransaction(-basePrice+(reciever.getSkillValue("Bargain")*2));
				transaction += "\nTransaction successful: You have " + reciever.getGold() + " gold left.";
				//System.out.println("Gold amount after: "+ reciever.getGold());
				this.unequipItem(e);
			} 
			else if(e.getButton() == RIGHT_CLICK){
				transaction += "\nTransaction failed: Not enough gold. You only have " + reciever.getGold() + " gold.";
				//transaction += "\nTransaction failed: Not enough gold. You only have " + reciever.getGold() + " gold.";
			}
			else{
				transaction += "\nItem Stats: " + item.toString();
			}
			GameLog.writeToLog("Item Transaction", transaction);
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
	
	public class MerchantCloseOp implements WindowListener{

		public void windowActivated(WindowEvent arg0) {
		}

		public void windowClosed(WindowEvent arg0) {
		}

		public void windowClosing(WindowEvent arg0) {
			entity.revertEngageBehavior();
		}

		public void windowDeactivated(WindowEvent arg0) {
		}

		public void windowDeiconified(WindowEvent arg0) {
		}

		public void windowIconified(WindowEvent arg0) {
		}

		public void windowOpened(WindowEvent arg0) {
		}}
	
}
