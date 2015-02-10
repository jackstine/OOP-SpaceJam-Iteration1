package controller;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import view.View;

public class ViewController {
	private View previous;
	private View current;
	private JFrame frame;
	
	private MainMenuController mainMenu;
	private CharacterCreationController newGame;
	//private LoadGamesTableController noLoad;
	private TestGameController loadGame;
	private TestGameController testGame;
	
	private Map<String, View> views = new HashMap<String, View>();
	
	public ViewController(){
		
		frame = new JFrame();
		
		mainMenu = new MainMenuController();
		views.put("Main", mainMenu.getView());
		
		newGame = new CharacterCreationController();	
		views.put("New", newGame.getView());
		
		if(new File("apple.ser").isFile()){
			loadGame = new TestGameController("apple.ser");
			views.put("Load", loadGame.getView());
		}
		else{
			views.put("Load", newGame.getView());
		}
		
		testGame = new TestGameController();		
		views.put("Test", testGame.getView());
			
		previous = null;
		current = views.get("Main");
		
		frame.setLayout(new FlowLayout());
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.add(current.getPanel());
		frame.setVisible(true);
		frame.repaint();
	}
	//Used to poll the active variable of the current view and changes views when active is set false.
	public void display(){
		if(!current.isActive()){
			changePanel();
		}
		if(testGame.pressedSave){
			hasSaved();
		}
	}
	//Changes switches views to the "next" view (specified by action listeners).
	public void changePanel(){
		previous = current;
		if(views.get(current.getNext()) == null){
			System.out.println("Illegal Path: " + current.getNext());
			current.setNext("Quit");
		}
		else{
			if(current.getNext() == "New"){
				testGame = new TestGameController();
				views.put("Test", testGame.getView());
			}
			current = views.get(current.getNext());
			current.reset();
			frame.remove(previous.getPanel());
			frame.add(current.getPanel());
			frame.revalidate();
			frame.repaint();
		}	
	}
	
	public void hasSaved(){
		loadGame = new TestGameController("apple.ser");
		views.put("Load", loadGame.getView());
		testGame.pressedSave = false;
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
