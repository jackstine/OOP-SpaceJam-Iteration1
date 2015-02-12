package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.GameController.SystemsMenu;
import view.View;

public class TestGameController extends SaveLoadController {
	private View testGame;
	public Apple apple;
	private JButton save;
	private JButton back;
	private JTextField label;
	private JLabel saved;
	private JButton menu;
	
	private JPanel canvas;
	private JLayeredPane layer1;
	private JInternalFrame layer2;
	private JPanel systemsMenu;
	
	public TestGameController(){
		testGame = new View();
		apple = new Apple();
		save = new JButton("save");
		label = new JTextField(20);
		saved = new JLabel(apple.s);
		back = new JButton("back");
		pressedSave = false;
		
		layer1 = new JLayeredPane();
		layer1.setPreferredSize(new Dimension(600,600));
		layer1.setBorder(new LineBorder(Color.black, 5));
		
		canvas = new JPanel();
		systemsMenu = new JPanel();
		
		layer2 = createLayer("layer2");
		
		menu = new JButton("menu");
		
		testGame.getPanel().add(layer1);
		layer1.add(saved);
		layer1.add(label);
		layer1.add(menu);
		//layer1.add(layer2);
		
		systemsMenu.add(save);
		systemsMenu.add(back);
		
		
		label.setBounds(200, 100, 200, 25);
		saved.setBounds(100, 100, 200, 25);
		menu.setBounds(0, 0, 100, 25);
		
		back.addActionListener(new BackButtonListener());
		save.addActionListener(new SaveGameButton());
		menu.addActionListener(new SystemsMenu());
		
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
			//testGame.setNext("Quit");
		}
	}
	
	public class SystemsMenu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			String[] options = {"Quit",
//            "Main"};
//        	int n = JOptionPane.showOptionDialog(testGame.getPanel(),
//        		    "How Should We Proceed:",
//        		    "System",
//        		    JOptionPane.YES_NO_OPTION,
//        		    JOptionPane.QUESTION_MESSAGE,
//        		    null,     //do not use a custom Icon
//        		    options,  //the titles of buttons
//        		    options[0]); //default button title
//        	if(n != -1){
//        		testGame.setNext(options[n]);
//        		testGame.setRedraw(true);
//        	}
			layer2 = createLayer("layer2");
			layer2.add(systemsMenu);
			layer1.add(layer2);
			testGame.setNext("Test");
    		testGame.setRedraw(true);
		}
	}
	
	public static JInternalFrame createLayer(String label) {
	    return new SelfInternalFrame(label);
	  }

	static class SelfInternalFrame extends JInternalFrame {
		public SelfInternalFrame(String s) {
			getContentPane().add(new JLabel(s), BorderLayout.CENTER);
			setBounds(50, 50, 500, 500);
			setResizable(true);
			setClosable(true);
			setMaximizable(true);
			setIconifiable(true);
			setTitle(s);
			setVisible(true);
		}
	}
}
