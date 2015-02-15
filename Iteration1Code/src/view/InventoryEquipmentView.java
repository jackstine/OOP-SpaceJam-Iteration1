package view;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.Scaling;
import model.Avatar;
import model.Equipment;
import model.Item;
import model.Point;

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
		this.addMouseListener(new InventoryEquipmentMouseListener());
		
		
		this.avatar = avatar;
		this.inventory = new InventoryView(avatar.getInventory());
		this.equipment = new EquipmentView(avatar.getEquipment());
		equipment.addMouseListener(new EquipmentMouseListener());
		this.stats = new JButton("Stats");
		this.title = new JLabel("<html><span style='font-size:30px;'><u>Inventory/Equipment</u></span><br></html>", JLabel.CENTER);
		add(this.title);
		add(this.inventory);
		add(this.equipment);
		
		setFocusable(true);
		setVisible(true);
	}
	
	public void displayAvatarPortrait() {
	}
	
	public void displayEquipment(Equipment e) {
	}
	
	public class EquipmentMouseListener implements MouseListener{
		private final int RIGHT_CLICK = MouseEvent.BUTTON3;
		private final int LEFT_CLICK = MouseEvent.BUTTON1;
		
		
		private Item unequipEquipmentSlot(MouseEvent e){
			int x = e.getX() / Scaling.EQUIPMENT_SLOT_WIDTH;
			int y = e.getY() / Scaling.EQUIPMENT_SLOT_HEIGHT;
			Point point = new Point(x,y);
			Item item =equipment.getEquipment().getItemFromSlot(point);
			if (inventory.getInventory().findAndEquip(item)){
				equipment.getEquipment().unequipSlot(point);
			}
			equipment.repaint();
			return item;
		}
		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			this.unequipEquipmentSlot(e);
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
	
	
}