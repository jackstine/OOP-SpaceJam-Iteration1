package view;



import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;
import model.Avatar;
import model.Equipment;
import model.Point;
import model.TakeableItem;

/*

CharacterMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

public class InventoryEquipmentView extends JPanel {
	private JLabel title;
	private JButton stats;
	private Avatar avatar;
	private InventoryView inventory;
	private EquipmentView equipment;
	//private Grid[][] inventory

	public InventoryEquipmentView(Avatar avatar) {
		
		//DELETE ME PLEASE
		setLayout(new BorderLayout());
		
		this.addMouseListener(new InventoryEquipmentMouseListener());
		this.avatar = avatar;
		this.inventory = new InventoryView(avatar.getInventory());
		inventory.addMouseListener(new InventoryMouseListener());
		this.equipment = new EquipmentView(avatar.getEquipment());
		equipment.addMouseListener(new EquipmentMouseListener());
		this.stats = new JButton("Stats");
		this.title = new JLabel("<html><span style='font-size:30px;'><u>Inventory/Equipment</u></span><br></html>", JLabel.CENTER);
		add(this.title, BorderLayout.NORTH);
		add(this.inventory,BorderLayout.WEST);
		add(this.equipment);
	}
	
	public void displayAvatarPortrait() {
	}
	
	public void displayEquipment(Equipment e) {
	}
	
	public class EquipmentMouseListener implements MouseListener{
		private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;
		
		
		private TakeableItem unequipEquipmentSlot(MouseEvent e){
			int x = e.getX() / Scaling.EQUIPMENT_SLOT_WIDTH;
			int y = e.getY() / Scaling.EQUIPMENT_SLOT_HEIGHT;
			Point point = new Point(x,y);
			TakeableItem item =equipment.getEquipment().getItemFromSlot(point);
			if (inventory.getInventory().findAndEquip(item)){
				equipment.getEquipment().unequipSlot(point);
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
	
	
	public class InventoryEquipmentMouseListener implements MouseListener{
		private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;

		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			System.out.println(e);
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
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
			inventory.getInventory().getSlot(slotPoint).unequip();
			System.out.println(slotPoint);
		}
		
		private void equipItem(MouseEvent e){
			Point pointOfSlot = this.getInventorySlot(e);
			TakeableItem item = inventory.getInventory().getSlot(pointOfSlot).unequip();
			if (item != null){
				item.action(avatar);
				equipment.repaint();
			}
		}
		
		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			System.out.println(e);
			if (e.getButton() == RIGHT_CLICK){
				this.unequipItem(e);
			}
			if (e.getButton()== LEFT_CLICK){
				this.equipItem(e);
			}
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	
}