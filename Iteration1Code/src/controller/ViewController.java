package controller;

import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import view.View;

public class ViewController {
	private View previous;
	private View current;
	private JFrame frame;
	
	private MainMenuView mainMenu;
	private CharacterCreation newGame;
	
	private Map<String, View> views = new HashMap<String, View>();
	
	public ViewController(){
		
		frame = new JFrame();
		mainMenu = new MainMenuView();
		newGame = new CharacterCreation();		
		
		views.put("Main", mainMenu.getView());
		views.put("New", newGame.getView());
			
		previous = null;
		current = views.get("Main");
		
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.add(current.getPanel());
		frame.setVisible(true);
		frame.repaint();
	}
	
	public void run(){
		if(current.isDone()){
			changePanel();
		}
	}
	
	public void changePanel(){
		previous = current;
		current = views.get(current.getNext());
		current.reset();
		frame.remove(previous.getPanel());
		frame.add(current.getPanel());
		frame.revalidate();
		frame.repaint();	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public View getCurrent() {
		return current;
	}

	public void setCurrent(View current) {
		this.current = current;
	}
}
