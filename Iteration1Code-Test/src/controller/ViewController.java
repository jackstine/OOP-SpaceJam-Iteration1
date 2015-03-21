package controller;
 
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 


import javax.swing.JFrame;
import javax.swing.Timer;

import model.Game;
import view.View;
 
/**
 * Main controller used to handle view changes and game state changes.<BR>
 * Also spawns all other view/game controllers and attaches the key listener.
 * @author Ryan
 *
 */
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
            if(new File("savedGame.txt").isFile()){
            	reLoad("Load");
            }
           else{
                inGame = new GameController();
                mv = new MapViewController();
                views.put("Game", charGen.getView());
            }

            current = views.get("Main");
            //set up the main frame
            frame.setFocusable(true);
            frame.setLayout(new FlowLayout());
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(current);
            frame.setVisible(true);
            frame.repaint();
        }
        /**
         * Used to start the timer, which polls for state changes
         */
        public void display(){
        	Timer timer = new Timer(20, new RunGameTimer());
    		timer.start();
        }
        /**
         * Changes switches views to the "next" view (specified by action listeners).
         */
        public void changePanel(){
                previous = current;
                if(views.get(current.getNext()) == null && !current.nextStateEquals("New")){
                    System.out.println("Illegal Path: " + current.getNext());
                    current.setNext("Quit");
                }
                else{
                    if(current.nextStateEquals("New")){
                    	reLoad("New");
                        current = views.get("Game");
                    }
                    else{
                        current = views.get(current.getNext());
                    }
                    current.reset();
                    frame.remove(previous);
                    frame.add(current);
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
        /**
         * Reloads game variables and their associated views.
         */
        public void reLoad(String command){
        	// the game only needs to be instantiated once, or we will loose information
        	Game game = null;
        	if(command.equals("Load")){	
        		try {
        	       	game = new Game();
    				game.load();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}
    		else if(command.equals("New")){
    			game = new Game(charGen.getOccupation(), charGen.getName());
    		}else{
    			game = new Game();
    		}
            inGame = new GameController(game);
            views.put("Game", inGame.getView());
            mv = new MapViewController(game.getWorld(),game.getAvatar(),frame, inGame.getMapView());
            inGame.stopReset();
            frame.revalidate();
            frame.repaint();
        }
        /**
         * Timer used to initiate changing views and reloading the game state.
         */
        public class RunGameTimer implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
    			if(current.nextStateEquals("Quit")){
    				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    			}
    			if(current.getRedraw()){
    				changePanel();
    			}
    			if(inGame.startReset()){ 
    				reLoad("Load");
    			}
    		}
    	}
}
