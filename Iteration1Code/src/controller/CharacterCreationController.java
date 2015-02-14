package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.*;
import utilities.Scaling;
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
	private JPanel buttons;
	private JPanel main;
	private JPanel back;
	private JPanel nameEntry;
	
	private Game gameToCreate;
	
	private Occupation occupationSelected;

	public CharacterCreationController(){
		charCreation = new View();
		backGameButton = new JButton("<html><span style='font-size:20px;'>Back</span></html>");
		startAlchemistButton = new JButton("<html><span style='font-size:20px;'>Alchemist</span></html>");
		startTerminatorButton = new JButton("<html><span style='font-size:20px;'>Terminator</span></html>");
		startHunterButton = new JButton("<html><span style='font-size:20px;'>Hunter</span></html>");
		title = new JLabel("<html><span style='font-size:40px;'><u>Character Creation</u></span><br><br><br><br></html>", JLabel.CENTER);
		buttons = new JPanel();
		main = new JPanel();
		back = new JPanel();
		
		enterNameLabel = new JLabel("<html><p style='font-size:20px;'>Name your character:</p><br></html>",JLabel.CENTER);
		
		charCreation.getCanvas().setPreferredSize(new Dimension(Scaling.CHARACTER_CREATION_WIDTH,Scaling.CHARACTER_CREATION_HEIGHT));
		charCreation.getCanvas().setBorder(new LineBorder(Color.black, 5));
		charCreation.getCanvas().setLayout(new BorderLayout());
		
		nameEntry = new JPanel();
		nameEntry.setLayout(new GridLayout(2,1));
		Font font = new Font("Arial", Font.BOLD,20);
		enterNameField = new JTextField("Arnold");
		enterNameField.setHorizontalAlignment(JTextField.CENTER);
		enterNameField.setFont(font);

		nameEntry.add(enterNameLabel);
		nameEntry.add(enterNameField);
		
		chooseOccupationLabel = new JLabel("<html><p style='font-size:20px;'>Choose your occupation:</p></html>", JLabel.CENTER);
		buttons.add(startHunterButton);
		buttons.add(startTerminatorButton);
		buttons.add(startAlchemistButton);
		
		back.add(backGameButton);
		
		main.setLayout(new GridLayout(4,1));
		
		main.add(nameEntry);
		main.add(chooseOccupationLabel);
		main.add(buttons);
		main.add(back);
		
		charCreation.getCanvas().add(title, BorderLayout.NORTH);
		charCreation.getCanvas().add(main, BorderLayout.CENTER);
		
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
			charCreation.setRedraw(true);
			
		}
	}
	
	public class TerminatorSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("New"); //Game View
			gameToCreate = new Game(new Terminator(), enterNameField.getText());
			charCreation.setRedraw(true);
			
		}
	}
	
	public class HunterSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("New"); //Game View
			gameToCreate = new Game(new Hunter(), enterNameField.getText());
			charCreation.setRedraw(true);
			
		}
	}
}
