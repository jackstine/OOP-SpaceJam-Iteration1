package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.View;


public class MainMenuController {
	private View mainMenuButtons;
	private JButton startGameButton;
	private JButton loadGameButton;
	private JButton quitGameButton;

	public MainMenuController(){
		
		mainMenuButtons = new View();
		startGameButton = new JButton("New");
		loadGameButton = new JButton("Load");
		quitGameButton = new JButton("Quit");
		
		mainMenuButtons.getPanel().add(startGameButton);
		mainMenuButtons.getPanel().add(loadGameButton);
		mainMenuButtons.getPanel().add(quitGameButton);
		
		startGameButton.addActionListener(new StartButtonListener());
		quitGameButton.addActionListener(new QuitButtonListener());
	}
	
	public View getView(){
		return mainMenuButtons;
	}
	
	public class StartButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenuButtons.setNext("New");
			mainMenuButtons.setActive(false);
		}
	}
	
	public class QuitButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenuButtons.setNext("Quit");
		}
	}
	
}
