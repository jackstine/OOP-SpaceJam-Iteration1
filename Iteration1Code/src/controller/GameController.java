package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Game;
import model.Point;
import view.CharacterMenuView;
import view.GameView;
import view.InventoryView;
import view.SystemMenuView;
import view.View;

public class GameController {
	
	//MISC
	private boolean saved = false;
	private boolean spawned = false;
	private Apple apple = new Apple(); //--TO BE REMOVED
	private Game game = new Game();
	
	//Components
	private JTextField input = new JTextField(20);
	private JLabel savedText = new JLabel(apple.s);
	private JButton systemButton = new JButton("menu");
	private JInternalFrame systemMenu;
	
	//Views
	private View gameView = new View();
	private GameView board = new GameView(game.getMap(),game.getAvatar());
	private CharacterMenuView status = new CharacterMenuView(game.getAvatar());
	
	public GameController(){
		
		//Add to the canvas
//		gameView.getCanvas().add(systemButton);
//		gameView.getCanvas().add(input);
//		gameView.getCanvas().add(savedText);
		gameView.getCanvas().add(board);
		status.setBorder(new LineBorder(Color.black, 5));
		gameView.getCanvas().add(status);
		
		//Alignment --NEEDS ADJUSTMENT
		//systemButton.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 5, 0, 100, 25);
		//input.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 106, 0, 200, 25);
		//savedText.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 306, 100, 200, 25);
		board.setBounds(5, 0, 700, 700);
		status.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 50,0, 700, 700);
		
		systemButton.setFocusable(false);
		systemButton.addActionListener(new SystemsMenuButton());
		
	}
	
	public GameController(String s){
		
		//Load Game
		apple = load();
		savedText = new JLabel(apple.s);
		
		//Add to the canvas
		gameView.getCanvas().add(systemButton);
		gameView.getCanvas().add(input);
		gameView.getCanvas().add(savedText);
		gameView.getCanvas().add(board);
		
		//Alignment --NEEDS ADJUSTMENTS
		systemButton.setBounds(0, 0, 100, 25);
		input.setBounds(101, 0, 200, 25);
		savedText.setBounds(100, 100, 200, 25);
		board.setBounds(500, 0, 700, 700);
		
		systemButton.addActionListener(new SystemsMenuButton());
		
	}
	
	/********************MISC OPERATIONS**********************/
	public View getView(){
		return gameView;
	}
	
	public boolean pressedSave(){
		return saved;
	}
	
	public Game getGame(){	
		return game;
	}
	
	public void spawnSystems(){
		if(!spawned){
			systemMenu = new SystemMenuView(new BackButtonListener(),new SaveGameButton(), new RetGameButton());
			gameView.getCanvas().add(systemMenu);
			systemMenu.moveToFront();
			gameView.setNext("Game");
			gameView.setRedraw(true);
			spawned = true;
		}
	}
	
	public void save(){
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("apple.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(apple);
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized data is saved in apple.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public Apple load(){
		  Apple a = null;
		  try
		  {
		     FileInputStream fileIn = new FileInputStream("apple.ser");
		     ObjectInputStream in = new ObjectInputStream(fileIn);
		     a = (Apple) in.readObject();
		     in.close();
		     fileIn.close();
		  }catch(IOException i)
		  {
		     i.printStackTrace();
		     return null;
		  }catch(ClassNotFoundException c)
		  {
		     System.out.println("Apple class not found");
		     c.printStackTrace();
		     return null;
		  }
		  return a;
	}
	
	/********************Action Listeners**********************/
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			gameView.setNext("Main");
			gameView.setRedraw(true);
		}
	}
	
	public class SaveGameButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			apple.s = input.getText();
			input.setText(apple.s);
			savedText.setText(apple.s);
			System.out.println("Saved: " + apple.s);
			save();
			saved = true;
		}
	}
	
	public class RetGameButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			gameView.getCanvas().remove(systemMenu);
			gameView.getCanvas().getTopLevelAncestor().requestFocus();
			spawned = false;
			gameView.setNext("Game");
			gameView.setRedraw(true);
		}
	}	

	
	public class SystemsMenuButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			spawnSystems();
		}
	}

	
}
