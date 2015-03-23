package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utilities.FontHandler;
import controller.mouse.InventoryEquipmentMouseHandler;
import model.GameLog;
import model.Point;
import model.entity.Avatar;
import model.slots.InventorySlot;

/*

CharacterMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

@SuppressWarnings("serial")
public class InventoryEquipmentView extends JPanel {
	private JLabel title;
	private Avatar avatar;
	private InventoryView inventory;
	private EquipmentView equipment;
	private SpellView spell;
	private InventoryEquipmentMouseHandler handler;
	private FontHandler fh = new FontHandler();
	private Font labelFont;
	private JLabel gold =  new JLabel("Gold :",SwingConstants.CENTER);

	public InventoryEquipmentView(Avatar avatar) {
				
		this.avatar = avatar;
		this.setBackground(new Color(169, 221, 221));
		this.inventory = new InventoryView(avatar.getInventory());
		inventory.addMouseListener(new InventoryMouseListener());
		inventory.addMouseMotionListener(new InventoryMouseMotionListener());
		this.equipment = new EquipmentView(avatar.getEquipment());
		equipment.addMouseListener(new EquipmentMouseListener());
		//this.spell = new SpellView(this.avatar);
		labelFont = fh.AfterDisasterFont();
		this.title = new JLabel("<html><span style='font-size:30px;'><u>Inventory/Equipment</u></span><br></html>", JLabel.CENTER);
		this.title.setFont(labelFont.deriveFont(25f));
		
		this.gold.setFont(labelFont.deriveFont(20f));
		updateGold();
		
		this.setLayout(new BorderLayout());
		add(this.title,BorderLayout.NORTH);
		//add(this.spell,BorderLayout.WEST);
		add(this.inventory,BorderLayout.CENTER);
		add(this.equipment,BorderLayout.EAST);
		add(gold,BorderLayout.SOUTH);
		
		this.handler = new InventoryEquipmentMouseHandler(avatar, this);
		
		setFocusable(true);
		setVisible(true);
	}
	
	public void updateGold(){
		gold.setText("Gold :" + avatar.getGold());
	}
	
	public void setDraggingSlot(InventorySlot slot){
		this.inventory.setDraggingSlot(slot);
	}
	
	public void setDraggingSlotPoint(Point point){
		this.inventory.setDraggingSlotPoint(point);
	}
	
	public void repaintInventoryView(){
		this.inventory.repaint();
	}
	
	public class EquipmentMouseListener implements MouseListener{
		// private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;
		
		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			int key = e.getButton();
			if (key == LEFT_CLICK){
				handler.unequipEquipmentSlot(e);
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	
	public class InventoryMouseListener implements MouseListener{
		private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;
		
		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == RIGHT_CLICK){
				if (avatar.getBuyingMode()){
					System.out.println("SELLING HERE");
					handler.sellItem(e);
					GameLog.writeToLog("Item Transaction", " Price: " + "\nTransaction successful: You have " + avatar.getGold() + " gold.");
				}
				else{
					System.out.println("UNEQUIPPING HERE");
					handler.unequipItem(e);
				}
			}
			if (e.getButton()== LEFT_CLICK){
				if(avatar.getBuyingMode()){
					GameLog.writeToLog("Item Stats", handler.getItemInfo(e));
				}
				else{
					GameLog.writeToLog("Item Stats", handler.getItemInfo(e));
					handler.useItem(e);
				}
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {
			handler.releaseItem(e);
		}
	}
	
	public class InventoryMouseMotionListener implements MouseMotionListener{

		public void mouseDragged(MouseEvent e) {
			handler.dragItem(e);
		}

		public void mouseMoved(MouseEvent e) {}
	}
	
	
}