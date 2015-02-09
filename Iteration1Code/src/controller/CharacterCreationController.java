package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.View;


public class CharacterCreationController {
	private View charCreation;
	private JButton startGameButton;

	public CharacterCreationController(){
		charCreation = new View();
		startGameButton = new JButton("Back");
		
		charCreation.getPanel().add(startGameButton);
		
		startGameButton.addActionListener(new BackButtonListener());
	}
	
	public View getView(){
		return charCreation;
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("Main");
			charCreation.setActive(false);
		}
	}
}
