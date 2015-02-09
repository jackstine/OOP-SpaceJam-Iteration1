package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.View;


public class CharacterCreation {
	private View charCreation;
	private JButton startGameButton;

	public CharacterCreation(){
		charCreation = new View("New", new JPanel());
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
			charCreation.setDone(true);
		}
	}
}
