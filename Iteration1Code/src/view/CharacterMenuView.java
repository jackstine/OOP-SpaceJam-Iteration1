package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import utilities.Scaling;
import controller.GameController.SystemsMenuButton;
import model.Avatar;
import model.Equipment;
import model.Inventory;
import model.Point;
import model.Stat;

import java.util.*;

/*

CharacterMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

public class CharacterMenuView extends JPanel {
	private JLabel title;
	private JButton stats;
	private Avatar avatar;
	private InventoryView inventory;
	private EquipmentView equipment;
	//private Grid[][] inventory

	public CharacterMenuView(Avatar avatar) {
		
		//DELETE ME PLEASE
		this.addMouseListener(new InventoryMouseListener());
		
		
		this.avatar = avatar;
		this.inventory = new InventoryView(avatar.getInventory());
		this.equipment = new EquipmentView(avatar.getEquipment());
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
	
	public class InventoryMouseListener implements MouseListener{
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