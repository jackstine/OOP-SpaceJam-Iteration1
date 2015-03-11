package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;
import model.Point;
import model.Entity.Avatar;
import model.items.TakeableItem;

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

	public InventoryEquipmentView(Avatar avatar) {
				
		this.avatar = avatar;
		this.inventory = new InventoryView(avatar.getInventory());
		inventory.addMouseListener(new InventoryMouseListener());
		this.equipment = new EquipmentView(avatar.getEquipment());
		equipment.addMouseListener(new EquipmentMouseListener());
		this.title = new JLabel("<html><span style='font-size:30px;'><u>Inventory/Equipment</u></span><br></html>", JLabel.CENTER);
		add(this.title);
		add(this.inventory);
		add(this.equipment);
		
		setFocusable(true);
		setVisible(true);
	}
	
	public class EquipmentMouseListener implements MouseListener{
		// private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;
		
		
		private TakeableItem unequipEquipmentSlot(MouseEvent e){
			int x = e.getX() / Scaling.EQUIPMENT_SLOT_WIDTH;
			int y = e.getY() / Scaling.EQUIPMENT_SLOT_HEIGHT;
			Point point = new Point(x,y);
			TakeableItem item = avatar.unequipEquipment(point);
			if (avatar.equipInventory(item)){
				avatar.unequipEquipment(point);
			}
			equipment.repaint();
			return item;
		}
		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			int key = e.getButton();
			if (key == LEFT_CLICK){
				this.unequipEquipmentSlot(e);
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

		private Point getInventorySlot(MouseEvent e){
			int x = e.getY()/Scaling.SLOT_VIEW_SCALE;
			int y = e.getX()/Scaling.SLOT_VIEW_SCALE;
			return new Point(x,y);
		}
		
		private void unequipItem(MouseEvent e){
			Point slotPoint = getInventorySlot(e);
			avatar.unequipInventorySlot(slotPoint);
		}
		
		private void useItem(MouseEvent e){
			Point pointOfSlot = this.getInventorySlot(e);
			//TODO CHANGE TO unequipSLOT()
			TakeableItem item = avatar.unequipInventorySlot(pointOfSlot);
			boolean notEmpty = item != null;
			if (notEmpty){
				item.action(avatar);
			}
			equipment.repaint();
		}
		
		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == RIGHT_CLICK){
				this.unequipItem(e);
			}
			if (e.getButton()== LEFT_CLICK){
				this.useItem(e);
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	
}