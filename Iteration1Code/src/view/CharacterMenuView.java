package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
	//private Grid[][] inventory

	public CharacterMenuView(Avatar avatar) {
		this.avatar = avatar;
		inventory = new InventoryView(avatar.getInventory(),new Point(0,0));
		stats = new JButton("Stats");
		title = new JLabel("<html><span style='font-size:30px;'><u>Inventory/Equipment</u></span><br></html>", JLabel.CENTER);
		add(title);
		add(inventory);
		
		setFocusable(true);
		setVisible(true);
	}
	
	public void displayAvatarPortrait() {
	}
	
	public void displayEquipment(Equipment e) {
	}
	
}