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


public class CharacterCreationController {
	private View charCreation;
	private JButton backGameButton;
	private JButton startAlchemistButton;
	private JButton startHunterButton;
	private JButton startTerminatorButton;
	private JLabel title;
	private JPanel buttons;
	private JPanel main;
	private JPanel back;

	public CharacterCreationController(){
		charCreation = new View();
		backGameButton = new JButton("<html><span style='font-size:20px;'>Back</span></html>");
		startAlchemistButton = new JButton("<html><span style='font-size:20px;'>Alchemist</span></html>");
		startTerminatorButton = new JButton("<html><span style='font-size:20px;'>Terminator</span></html>");
		startHunterButton = new JButton("<html><span style='font-size:20px;'>Hunter</span></html>");
		title = new JLabel("<html><span style='font-size:40px;'><u>Character Creation</u></span><br><br><br><br><p style='font-size:10px;'>Choose an occupation to begin:</p></html>", JLabel.CENTER);
		buttons = new JPanel();
		main = new JPanel();
		back = new JPanel();
		
		charCreation.getCanvas().setPreferredSize(new Dimension(600, 600));
		charCreation.getCanvas().setBorder(new LineBorder(Color.black, 5));
		charCreation.getCanvas().setLayout(new BorderLayout());
		
		buttons.add(startHunterButton);
		buttons.add(startTerminatorButton);
		buttons.add(startAlchemistButton);
		
		back.add(backGameButton);
		
		main.setLayout(new GridLayout(4,1));
		
		main.add(new JPanel());
		main.add(buttons);
		main.add(new JPanel());
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
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("Main");
			charCreation.setRedraw(true);
		}
	}
	
	public class AlchemistSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext(""); //Game View
			charCreation.setRedraw(true);
		}
	}
	
	public class TerminatorSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("New"); //Game View
			charCreation.setRedraw(true);
		}
	}
	
	public class HunterSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("h"); //Game View
			charCreation.setRedraw(true);
		}
	}
}
