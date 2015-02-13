package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import Test.MapTest;
import controller.GameController.SystemsMenu;
import view.GameView;
import view.View;

public class TestGameController extends SaveLoadController {
	private View testGame = new View();
	public Apple apple = new Apple();
	private JTextField label = new JTextField(20);
	private JLabel saved = new JLabel(apple.s);
	private JButton menu;
	private MapViewController mv;
	public GameView game = new GameView();
	
	private JLayeredPane layer1 = new JLayeredPane();
	private JInternalFrame layer2;
	
	public TestGameController(){		
		pressedSave = false;
		layer1.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
				
		menu = new JButton("menu");
		
		testGame.getPanel().add(layer1);
		layer1.add(saved);
		layer1.add(label);
		layer1.add(menu);
		layer1.add(game);
		mv = new MapViewController(game.getMap(),game.getAvatar(),game);
		
		
		label.setBounds(101, 0, 200, 25);
		game.setBounds(500, 0, 700, 700);
		saved.setBounds(100, 100, 200, 25);
		menu.setBounds(0, 0, 100, 25);
		
		menu.addActionListener(new SystemsMenuButton());
		
		layer1.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),
                "pressed");
		layer1.getActionMap().put("pressed",
				new doNothing());
		
	}
	
	public TestGameController(JFrame frame){		
		pressedSave = false;
		layer1.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());		
		menu = new JButton("menu");
		
		testGame.getPanel().add(layer1);
		layer1.add(saved);
		layer1.add(label);
		layer1.add(menu);
		layer1.add(game);
		
		label.setBounds(101, 0, 200, 25);
		game.setBounds(500, 0, 700, 700);
		saved.setBounds(100, 100, 200, 25);
		menu.setBounds(0, 0, 100, 25);
		
		menu.addActionListener(new SystemsMenuButton());
		
	}
	
	public TestGameController(String file){
		testGame = new View();
		apple = new Apple();
		load(this);
		label = new JTextField(20);
		saved = new JLabel(apple.s);
		label.setText(apple.s);
		pressedSave = false;
		
		testGame.getPanel().add(saved);
		testGame.getPanel().add(label);
		
		
		
	}
	
	public View getView(){
		return testGame;
	}
	
	public class doNothing extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			layer2 = new SystemsMenu();
			layer1.add(layer2);
			layer2.moveToFront();
			testGame.setNext("Test");
    		testGame.setRedraw(true);
    		System.out.println("pressed");
			
		}
		
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			testGame.setNext("Main");
			testGame.setRedraw(true);
		}
	}
	
	public class LoadButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			load(TestGameController.this);
			label.setText(apple.s);
			saved.setText(apple.s);
			testGame.setNext("Load");
			testGame.setRedraw(true);
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
			testGame.setRedraw(true);
		}
	}
	
	public class SystemsMenuButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			layer2 = new SystemsMenu();
			layer1.add(layer2);
			layer2.moveToFront();
			testGame.setNext("Test");
    		testGame.setRedraw(true);
		}
	}
	
	public class SystemsMenu extends JInternalFrame {
		private JButton save = new JButton("save");
		private JButton back = new JButton("back");
		private JPanel systemsMenu = new JPanel();
		public SystemsMenu() {
			getContentPane().add(new JLabel("System Menu"), BorderLayout.CENTER);
			setBounds(50, 50, 500, 500);
			setClosable(true);
			setTitle("System Menu");
			systemsMenu.add(save);
			systemsMenu.add(back);
			add(systemsMenu);
			setVisible(true);
			
			back.addActionListener(new BackButtonListener());
			save.addActionListener(new SaveGameButton());
		}
	}
}
