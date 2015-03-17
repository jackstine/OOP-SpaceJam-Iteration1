package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.mouse.InventoryEquipmentMouseHandler;
import model.Entity.Avatar;

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

	public InventoryEquipmentView(Avatar avatar) {
				
		this.avatar = avatar;
		this.inventory = new InventoryView(avatar.getInventory());
		inventory.addMouseListener(new InventoryMouseListener());
		this.equipment = new EquipmentView(avatar.getEquipment());
		equipment.addMouseListener(new EquipmentMouseListener());
		this.spell = new SpellView(this.avatar);
		this.title = new JLabel("<html><span style='font-size:30px;'><u>Inventory/Equipment</u></span><br></html>", JLabel.CENTER);
	
		this.setLayout(new BorderLayout());
		add(this.title,BorderLayout.NORTH);
		add(this.spell,BorderLayout.WEST);
		add(this.inventory,BorderLayout.CENTER);
		add(this.equipment,BorderLayout.EAST);
		
		this.handler = new InventoryEquipmentMouseHandler(avatar, this);
		
		setFocusable(true);
		setVisible(true);
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
				handler.unequipItem(e);
			}
			if (e.getButton()== LEFT_CLICK){
				handler.useItem(e);
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	
}