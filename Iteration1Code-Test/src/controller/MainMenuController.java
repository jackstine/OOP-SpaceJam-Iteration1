package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainMenuView;
import view.View;

public class MainMenuController {
	
	private MainMenuView mainMenu = new MainMenuView(new StartButtonListener(),new LoadButtonListener(), new QuitButtonListener());
	
	public View getView(){
		return mainMenu;
	}
	
	public class StartButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenu.setNext("Character");
			mainMenu.setRedraw(true);
		}
	}
	
	public class LoadButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenu.setNext("Game");
			mainMenu.setRedraw(true);
		}
	}
	
	public class QuitButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenu.setNext("Quit");
		}
	}
	
}
