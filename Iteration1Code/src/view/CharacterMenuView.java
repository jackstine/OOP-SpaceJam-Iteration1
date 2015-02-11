package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

/*

CharacterMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

public class CharacterMenuView extends JPanel {

	private JButton levelUpButton;
	//private Grid[][] inventory

	public CharacterMenuView() {
		levelUpButton = new JButton("Level Up!");
	}
	
	public void displayStats(HashMap<String, Stat) {
	}
	
	public void displayInventory(Inventory i) {
	}
	
	public void displayAvatarPortrait() {
	}
	
	public void displayEquipment(Equipment e) {
	}
	
}