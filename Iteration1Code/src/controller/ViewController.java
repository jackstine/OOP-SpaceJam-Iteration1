package controller;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import view.View;

public class ViewController {
	
	//lesser controllers
	private MainMenuController mainMenu;
	private CharacterCreationController charGen;
	private GameController inGame;
	
	//key listener
	private MapViewController mv;
	
	//MISC
	private View previous;
	private View current;
	private JFrame frame;
	private Map<String, View> views = new HashMap<String, View>();
	
	public ViewController(){
		//instantiate the main frame
		frame = new JFrame();
		
		//instantiate the main menu controller + view
		mainMenu = new MainMenuController();
		views.put("Main", mainMenu.getView());
		
		//instantiate the character creator controller + view
		charGen = new CharacterCreationController();	
		views.put("Character", charGen.getView());
		
		
		//instantiate the game controller + view 
		if(new File("apple.ser").isFile()){
			inGame = new GameController();
			views.put("Game", inGame.getView());
		}
		else{
			inGame = new GameController();
			views.put("Game", charGen.getView());
		}
		
		//Create New Game Path
		views.put("New", inGame.getView());
		
		mv = new MapViewController(inGame,frame); //modify this later.
		current = views.get("Main");
		//set up the main frame
		frame.setFocusable(true);
		frame.setLayout(new FlowLayout());
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.add(current.getCanvas());
		frame.setVisible(true);
		frame.repaint();
	}
	//Used to poll the active variable of the current view and changes views when active is set false.
	public void display(){
		if(current.getRedraw()){
			changePanel();
		}
		if(inGame.pressedSave()){
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
			if(current.getNext().equals("New")){
				
				inGame = new GameController(charGen.getGameToCreate());
				views.put("Game", inGame.getView());
				mv = new MapViewController(inGame,frame);
				current = views.get("Game");
			}
			else{
				current = views.get(current.getNext());
			}
			current.reset();
			frame.remove(previous.getCanvas());
			frame.add(current.getCanvas());
			frame.revalidate();
			frame.repaint();
		}
		if(current == views.get("Game")){
			mv.setActive(true);
		}
		else{
			mv.setActive(false);
		}
	}
	
	public void hasSaved(){
		inGame = new GameController();
		views.put("Game", inGame.getView());
		mv = new MapViewController(inGame,frame);
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
