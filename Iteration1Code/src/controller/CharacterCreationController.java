package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import view.MainMenuButton;


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
		Font labelFont = new Font("serif", Font.PLAIN, 24);
		
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/Apocalypse_Now.ttf"));
			labelFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/res/fonts/After_Disaster.ttf"));
			System.out.println("IT WORKED!");
		} catch (Exception e) {
			System.out.println("boop");
		}
		
		title = new JLabel("CHARACTER CREATION");
		title.setFont(titleFont.deriveFont(100f));
		
		backgroundPanel = new ImagePanel("src/res/img/main_menu_bg.gif");
		
		backgroundPanel.setLayout(new GridBagLayout());//(FlowLayout.CENTER, 350, 5));
		GridBagConstraints c = new GridBagConstraints();
		
		ImageIcon terminatorButtonLogo = new ImageIcon("src/res/img/terminator3.png");
		ImageIcon alchemistButtonLogo = new ImageIcon("src/res/img/alchemist3.png");
		ImageIcon hunterButtonLogo = new ImageIcon("src/res/img/hunter3.png");
		
		backGameButton = new MainMenuButton("       <Back>", labelFont);
		
		startAlchemistButton = new CharacterCreationButton(alchemistButtonLogo);
		startTerminatorButton = new CharacterCreationButton(terminatorButtonLogo);
		startHunterButton = new CharacterCreationButton(hunterButtonLogo);
		
		JLabel terminatorLabel = new JLabel("  Terminator");
		terminatorLabel.setForeground(Color.WHITE);
		Font labelFontRedux = labelFont.deriveFont(40f);
		terminatorLabel.setFont(labelFontRedux);
		
		JLabel alchemistLabel = new JLabel("   Alchemist");
		alchemistLabel.setForeground(Color.WHITE);
		alchemistLabel.setFont(labelFontRedux);
		
		JLabel hunterLabel = new JLabel("        Hunter");
		hunterLabel.setForeground(Color.WHITE);
		hunterLabel.setFont(labelFontRedux);
		
		//title = new JLabel();
		buttons = new JPanel();
		main = new JPanel();
		back = new JPanel();
		
		enterNameLabel = new JLabel("Name your character");
		enterNameLabel.setFont(labelFontRedux);
		enterNameLabel.setForeground(Color.WHITE);
		
		enterNameField = new JTextField("Arnold");
		enterNameField.setHorizontalAlignment(JTextField.CENTER);
		enterNameField.setFont(labelFontRedux);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 30;
		c.gridwidth = 3;
		backgroundPanel.add(title, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		backgroundPanel.add(enterNameLabel, c);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		backgroundPanel.add(backGameButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		backgroundPanel.add(enterNameField, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startTerminatorButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startAlchemistButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startHunterButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(terminatorLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(alchemistLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(hunterLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;

		
		//back.add(backGameButton);
		
		
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
