package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import model.Item;
import model.Location;
import model.Occupation;

import model.Point;
import utilities.Scaling;
import view.CharacterMenuView;
import view.GameView;
import view.InventoryView;
import view.StatisticsView;
import view.StatusView;
import view.SystemMenuView;
import view.View;

public class GameController {
	
	//Dimensions
	int boardDimensions[] = {Scaling.BOARD_X,Scaling.BOARD_Y,Scaling.BOARD_WIDTH,Scaling.BOARD_HEIGHT};
	int characterDimensions[] = {Scaling.CHAR_X , Scaling.CHAR_Y, Scaling.CHAR_WIDTH, Scaling.CHAR_HEIGHT};
	int buttonDimensions[] = {Scaling.SYSTEM_BUTTON_X , Scaling.SYSTEM_BUTTON_Y, Scaling.SYSTEM_BUTTON_WIDTH, Scaling.SYSTEM_BUTTON_HEIGHT};
	int statusDimensions[] = {Scaling.STATUS_X , Scaling.STATUS_Y, Scaling.STATUS_WIDTH, Scaling.STATUS_HEIGHT};
	
	//MISC
	private boolean saved = false;
	private boolean spawned = false;
	private Apple apple = new Apple(); //--TO BE REMOVED
	private Game game = new Game();
	
	//Components
	private JTextField input = new JTextField(20);
	private JLabel savedText = new JLabel(apple.s);
	private JPanel buttons = new JPanel();
	private JButton systemButton = new JButton("Systems");
	private JButton statButton = new JButton("Statistics");
	private JButton levelUp = new JButton("Level Up!");
	private JInternalFrame systemMenu;
	private JInternalFrame statsView;
	
	//Views
	private View gameView = new View();
	private GameView board = new GameView(game.getMap(),game.getAvatar());
	private CharacterMenuView character = new CharacterMenuView(game.getAvatar());
	private StatusView statusView = new StatusView(game.getAvatar());
	
	public GameController(){
		board.addMouseListener(new BoardMouseListener());
		
		//Add to the canvas
		buttons.add(systemButton);
		buttons.add(statButton);
		buttons.add(levelUp);
		buttons.setBorder(new LineBorder(Color.black, 3));
		gameView.getCanvas().add(buttons);
//		gameView.getCanvas().add(input);
//		gameView.getCanvas().add(savedText);
		gameView.getCanvas().add(board);
		character.setBorder(new LineBorder(Color.black, 3));
		gameView.getCanvas().add(character);
		gameView.getCanvas().add(statusView);
		
		//Alignment --NEEDS ADJUSTMENT
		//systemButton.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 5, 0, 100, 25);
		//input.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 106, 0, 200, 25);
		//savedText.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 306, 100, 200, 25);

		board.setBounds(boardDimensions[0],boardDimensions[1],boardDimensions[2],boardDimensions[3]);
		character.setBounds(characterDimensions[0], characterDimensions[1], characterDimensions[2], characterDimensions[3]);
		buttons.setBounds(buttonDimensions[0],buttonDimensions[1], buttonDimensions[2], buttonDimensions[3]);
		statusView.setBounds(statusDimensions[0],statusDimensions[1], statusDimensions[2], statusDimensions[3]);
		
		levelUp.setFocusable(false);
		
		systemButton.setFocusable(false);
		systemButton.addActionListener(new SystemsMenuButton()); 
		
		statButton.setFocusable(false);
		statButton.addActionListener(new StatButtonAction());
		
	}
	
	public GameController(Game gameToCreate){
		
		//Load Game
		apple = load();
		savedText = new JLabel(apple.s);
		
		game = gameToCreate;
		board = new GameView(game.getMap(),game.getAvatar());
		character = new CharacterMenuView(game.getAvatar());
		statusView = new StatusView(game.getAvatar());
		
		//Add to the canvas
		buttons.add(systemButton);
		buttons.add(statButton);
		buttons.add(levelUp);
		buttons.setBorder(new LineBorder(Color.black, 3));
		gameView.getCanvas().add(buttons);
//				gameView.getCanvas().add(input);
//				gameView.getCanvas().add(savedText);
		gameView.getCanvas().add(board);
		character.setBorder(new LineBorder(Color.black, 3));
		gameView.getCanvas().add(character);
		gameView.getCanvas().add(statusView);
		
		//Alignment --NEEDS ADJUSTMENT
		//systemButton.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 5, 0, 100, 25);
		//input.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 106, 0, 200, 25);
		//savedText.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 + 306, 100, 200, 25);

		board.setBounds(boardDimensions[0],boardDimensions[1],boardDimensions[2],boardDimensions[3]);
		character.setBounds(characterDimensions[0], characterDimensions[1], characterDimensions[2], characterDimensions[3]);
		buttons.setBounds(buttonDimensions[0],buttonDimensions[1], buttonDimensions[2], buttonDimensions[3]);
		statusView.setBounds(statusDimensions[0],statusDimensions[1], statusDimensions[2], statusDimensions[3]);
		
		systemButton.setFocusable(false);
		systemButton.addActionListener(new SystemsMenuButton()); 
		
		statButton.setFocusable(false);
		statButton.addActionListener(new StatButtonAction());
		
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
	
	public void spawnStats(){
		if(!spawned){			
			statsView = new StatisticsView(game.getAvatar(), new RetGameStatsButton());
			gameView.getCanvas().add(statsView);
			statsView.moveToFront();
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
	
	
	public class RetGameStatsButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			gameView.getCanvas().remove(statsView);
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
	
	public class StatButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			spawnStats();
		}
	}

	public class BoardMouseListener implements MouseListener{
		// all these classes need to be defined in the MapView
		
		
		// Point of Reference needs to be added to the tileY and tileX
		// the point of reference is the point that reflects the change in the display of the map
		public Location getTileLocation(MouseEvent e){
			int tileY = e.getY()/Scaling.TILE_HEIGHT;
			int tileX = e.getX()/Scaling.TILE_WIDTH;
			Point gameLocation = board.getMap().getDelta();
			int xOff = gameLocation.getX()/Scaling.TILE_WIDTH;
			int yOff = gameLocation.getY()/Scaling.TILE_HEIGHT;
			return new Location(tileX+xOff,tileY+yOff);
		}
		
		public void mouseClicked(MouseEvent e) {
			Location tileLocation = this.getTileLocation(e);
			//TRANSACTION   USE get ,  if room in Inventory  then drop,  else do nothing
			Item droppedItem = board.getMap().getTile(tileLocation).getItem();
			System.out.println(droppedItem+"  "+tileLocation);
			if (board.getAvatar().getInventory().findAndEquip(droppedItem)){
				board.getMap().getTile(tileLocation).dropItem();
			}
		}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
}
