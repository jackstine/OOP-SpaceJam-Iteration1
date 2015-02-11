package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*

SystemMenuView Class
Displays system options when the game is paused by the user
Consists of three buttons for saving, quitting, and 'saving and quitting' the game

*/

public class SystemMenuView extends JPanel {
	
	private JButton saveGameButton;
	private JButton quitGameButton;
	private JButton saveAndQuitGameButton;
	
	public SystemMenuView() {
		setLayout(new FlowLayout());
		
		saveGameButton = new JButton("Save");
		quitGameButton = new JButton("Quit");
		saveAndQuitGameButton = new JButton("Save & Quit");
		
		add(saveGameButton);
		add(quitGameButton);
		add(saveAndQuitGameButton);
	}
}