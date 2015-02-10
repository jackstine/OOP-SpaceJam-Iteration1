package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.View;

public class TestGameController extends SaveLoadController {
	private View testGame;
	public Apple apple;
	private JButton save;
	private JButton back;
	private JTextField label;
	private JLabel saved;
	
	public TestGameController(){
		testGame = new View();
		apple = new Apple();
		save = new JButton("save");
		label = new JTextField(20);
		saved = new JLabel(apple.s);
		back = new JButton("back");
		pressedSave = false;
		
		testGame.getPanel().add(save);
		testGame.getPanel().add(saved);
		testGame.getPanel().add(label);
		testGame.getPanel().add(back);
		
		back.addActionListener(new BackButtonListener());
		save.addActionListener(new SaveGameButton());
		
	}
	
	public TestGameController(String file){
		testGame = new View();
		apple = new Apple();
		load(this);
		save = new JButton("save");
		label = new JTextField(20);
		saved = new JLabel(apple.s);
		back = new JButton("back");
		label.setText(apple.s);
		pressedSave = false;
		
		testGame.getPanel().add(save);
		testGame.getPanel().add(saved);
		testGame.getPanel().add(label);
		testGame.getPanel().add(back);
		
		back.addActionListener(new BackButtonListener());
		save.addActionListener(new SaveGameButton());
		
	}
	
	public View getView(){
		return testGame;
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			testGame.setNext("Main");
			testGame.setActive(false);
		}
	}
	
	public class LoadButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			load(TestGameController.this);
			label.setText(apple.s);
			saved.setText(apple.s);
			testGame.setNext("Load");
			testGame.setActive(false);
		}
	}
	
	public class SaveGameButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			apple.s = label.getText();
			System.out.println("Saved: " + apple.s);
			save(TestGameController.this);
			pressedSave = true;
			label.setText(apple.s);
			saved.setText(apple.s);
			testGame.setNext("Load");
			testGame.setActive(false);
			//testGame.setNext("Quit");
		}
	}
}
