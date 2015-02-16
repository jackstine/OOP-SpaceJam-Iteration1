package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.*;
import utilities.Scaling;
import view.CharacterCreationButton;
import view.ImagePanel;
import view.View;


public class CharacterCreationController {
	private View charCreation;
	private JButton backGameButton;
	private JButton startAlchemistButton;
	private JButton startHunterButton;
	private JButton startTerminatorButton;
	private JLabel enterNameLabel;
	private JTextField enterNameField;
	private JLabel title;
	private JLabel chooseOccupationLabel;
	private JPanel backgroundPanel;
	private JPanel buttons;
	private JPanel main;
	private JPanel back;
	private JPanel nameEntry;
	private final int STARTINGX=3;
	private final int STARTINGY=3;
	
	private Game gameToCreate;
	
	private Occupation occupationSelected;

	public CharacterCreationController(){
		charCreation = new View();
		charCreation.getCanvas().setPreferredSize(new Dimension(Scaling.CHARACTER_CREATION_WIDTH, Scaling.CHARACTER_CREATION_HEIGHT));
		//charCreation.getCanvas().setBorder(new LineBorder(Color.black, 5));
		charCreation.getCanvas().setLayout(new BorderLayout());
		
		Font titleFont = new Font("serif", Font.PLAIN, 24);
		Font buttonFont = new Font("serif", Font.PLAIN, 24);
		
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/Apocalypse_Now.ttf"));
			buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/After_Disaster.ttf"));
			System.out.println("IT WORKED!");
		} catch (Exception e) {
			System.out.println("boop");
		}
		
		backgroundPanel = new ImagePanel("src/res/img/main_menu_bg.gif");
		
		backgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 700, 5));
		
		ImageIcon terminatorButtonLogo = new ImageIcon("src/res/img/terminator2.png");
		ImageIcon alchemistButtonLogo = new ImageIcon("src/res/img/alchemist2.png");
		ImageIcon hunterButtonLogo = new ImageIcon("src/res/img/hunter2.png");
		
		backGameButton = new JButton();
		startAlchemistButton = new CharacterCreationButton(alchemistButtonLogo);
		startTerminatorButton = new CharacterCreationButton(terminatorButtonLogo);
		startHunterButton = new CharacterCreationButton(hunterButtonLogo);
		title = new JLabel();
		buttons = new JPanel();
		main = new JPanel();
		back = new JPanel();
		
		enterNameLabel = new JLabel("<html><p style='font-size:20px;'>Name your character:</p><br></html>",JLabel.CENTER);
		
		//charCreation.getCanvas().setPreferredSize(new Dimension(Scaling.CHARACTER_CREATION_WIDTH,Scaling.CHARACTER_CREATION_HEIGHT));

		nameEntry = new JPanel();
		nameEntry.setLayout(new GridLayout(2,1));
		Font font = new Font("Arial", Font.BOLD,20);
		enterNameField = new JTextField("Arnold");
		enterNameField.setHorizontalAlignment(JTextField.CENTER);
		enterNameField.setFont(font);

		nameEntry.add(enterNameLabel);
		nameEntry.add(enterNameField);
		
		chooseOccupationLabel = new JLabel("<html><p style='font-size:20px;'>Choose your occupation:</p></html>", JLabel.CENTER);
		//backgroundPanel.add(startTerminatorButton);
		backgroundPanel.add(startAlchemistButton);
		//backgroundPanel.add(startHunterButton);
		
		back.add(backGameButton);
		
		main.setLayout(new GridLayout(4,1));
		
		main.add(nameEntry);
		main.add(chooseOccupationLabel);
		main.add(buttons);
		main.add(back);
		
		//charCreation.getCanvas().add(title, BorderLayout.NORTH);
		//charCreation.getCanvas().add(main, BorderLayout.CENTER);
		
		charCreation.getCanvas().add(backgroundPanel);
		
		backGameButton.addActionListener(new BackButtonListener());
		startAlchemistButton.addActionListener(new AlchemistSelectListener());
		startTerminatorButton.addActionListener(new TerminatorSelectListener());
		startHunterButton.addActionListener(new HunterSelectListener());
	}
	
	public View getView(){
		return charCreation;
	}
	
	public Game getGameToCreate() {
		return gameToCreate;
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("Main");
			charCreation.setRedraw(true);
			
		}
	}
	
	public class AlchemistSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("New"); //Game View
			gameToCreate = new Game(new Alchemist(), enterNameField.getText());
			//gameToCreate.getMap().updateEntityLocation(gameToCreate.getAvatar(), new Location(STARTINGX,STARTINGY));
			charCreation.setRedraw(true);
			
		}
	}
	
	public class TerminatorSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("New"); //Game View
			gameToCreate = new Game(new Terminator(), enterNameField.getText());
			//gameToCreate.getMap().updateEntityLocation(gameToCreate.getAvatar(), new Location(STARTINGX,STARTINGY));
			charCreation.setRedraw(true);
			
		}
	}
	
	public class HunterSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("New"); //Game View
			gameToCreate = new Game(new Hunter(), enterNameField.getText());
			//gameToCreate.getMap().updateEntityLocation(gameToCreate.getAvatar(), new Location(STARTINGX,STARTINGY));
			charCreation.setRedraw(true);
			
		}
	}

}
