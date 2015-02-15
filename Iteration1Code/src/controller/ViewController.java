package controller;
 
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
 
import javax.swing.JFrame;
import javax.swing.Timer;

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
        	Timer timer = new Timer(20, new RunGameTimer());
    		timer.start();
        }
        //Changes switches views to the "next" view (specified by action listeners).
        public void changePanel(){
                previous = current;
                if(views.get(current.getNext()) == null && !current.getNext().equals("New")){
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
 
        public class RunGameTimer implements ActionListener {
    		public void actionPerformed(ActionEvent e) {
    			if(current.getNext().equals("Quit")){
    				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    			}
    			if(current.getRedraw()){
    				changePanel();
    			}
    			if(inGame.pressedSave()){
    				hasSaved();
    			}
    		}
    	}
}
