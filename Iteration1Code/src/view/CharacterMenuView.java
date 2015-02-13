package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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

	private JButton levelUpButton;
	private Avatar avatar;
	private InventoryView inventory;
	//private Grid[][] inventory

	public CharacterMenuView(Avatar avatar) {
		this.avatar = avatar;
		inventory = new InventoryView(avatar.getInventory(),new Point(0,0));
		levelUpButton = new JButton("Level Up!");
		add(inventory);
		add(levelUpButton);
		add(levelUpButton);
		setFocusable(true);
		setVisible(true);
	}
	
	public void displayStats(HashMap<String, Stat> h) {
	}
	
	public void displayAvatarPortrait() {
	}
	
	public void displayEquipment(Equipment e) {
	}
	
}