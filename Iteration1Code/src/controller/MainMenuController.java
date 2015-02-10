package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import view.View;


public class MainMenuController {
	private View mainMenu;
	private JButton startGameButton;
	private JButton loadGameButton;
	private JButton quitGameButton;
	private JLabel title;
	private JPanel buttons;
	private JPanel b1;
	private JPanel b2;
	private JPanel b3;
	public MainMenuController(){
		
		mainMenu = new View();
		startGameButton = new JButton("<html><span style='font-size:20px; font-family:Papyrus'>New</span></html>");
		loadGameButton = new JButton("<html><span style='font-size:20px; font-family:Papyrus'>Load</span></html>");
		quitGameButton = new JButton("<html><span style='font-size:20px; font-family:Papyrus'>Quit</span></html>");
		title = new JLabel("<html><span style='font-size:40px; font-family:Papyrus'><u>Main Menu</u></span></html>", JLabel.CENTER);
		buttons = new JPanel();
		b1 = new JPanel();
		b2 = new JPanel();
		b3 = new JPanel();
		
		buttons.setLayout(new GridLayout(4,1));
		
		mainMenu.getPanel().setPreferredSize(new Dimension(600, 600));
		mainMenu.getPanel().setBorder(new LineBorder(Color.black, 5));
		mainMenu.getPanel().setLayout(new BorderLayout());
		
		b1.add(startGameButton);
		b2.add(loadGameButton);
		b3.add(quitGameButton);
		
		buttons.add(new JPanel());
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		
		mainMenu.getPanel().add(title, BorderLayout.NORTH);
		mainMenu.getPanel().add(buttons,BorderLayout.CENTER);
		
		startGameButton.addActionListener(new StartButtonListener());
		quitGameButton.addActionListener(new QuitButtonListener());
		loadGameButton.addActionListener(new LoadButtonListener());
	}
	
	public View getView(){
		return mainMenu;
	}
	
	public class StartButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenu.setNext("New");
			mainMenu.setActive(false);
		}
	}
	
	public class LoadButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenu.setNext("Load");
			mainMenu.setActive(false);
		}
	}
	
	public class QuitButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			mainMenu.setNext("Quit");
		}
	}
	
}
