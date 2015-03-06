package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JInternalFrame;
import javax.swing.Timer;

import model.Avatar;
import model.Game;
import model.GameMap;
import model.Location;
 
import model.Point;
import model.items.TakeableItem;
import utilities.Scaling;
import view.CombinedGameView;
import view.LevelUpView;
import view.MapView;
import view.StatisticsView;
import view.SystemMenuView;
import view.View;
 
public class GameController {
        
		private GameMap map;
		private Avatar avatar;
        private boolean reset = false;
        private boolean spawned = false;
        private int yourLvl;
        
        private CombinedGameView combinedGameView = null;
        private JInternalFrame systemMenu;
        private JInternalFrame statsView;
        private JInternalFrame leveledView;
        
        public GameController(){
        	//This should never be called.
        }
        
        public GameController(Game game){
        	this.map = game.getMap();
        	this.avatar = game.getAvatar();
        	yourLvl = avatar.getStatValue("Level");
        	combinedGameView = new CombinedGameView(map, avatar, new BoardMouseListener(), new LevelUPButton(), new SystemsMenuButton(), new StatButtonAction());
        	Timer timer = new Timer(20, new DeathLevelCheck());
     		timer.start();
        }
       
        
       
        /********************MISC OPERATIONS**********************/
        public View getView(){
                return combinedGameView;
        }
       
        public boolean startReset(){
                return reset;
        }
        
        public void stopReset(){
            reset  = false;
        }
       
//        public Game getGame(){ 
//                return game;
//        }
       
        public void spawnSystems(){
                if(!spawned){
                    systemMenu = new SystemMenuView(new BackButtonListener(),new SaveGameButton(), new RetGameButton());
                    combinedGameView.addExternalView(systemMenu);
                    systemMenu.moveToFront();
                    combinedGameView.setNext("Game");
                    combinedGameView.setRedraw(true);
                    spawned = true;
                }
        }
       
        public void spawnStats(){
                if(!spawned){                  
                    statsView = new StatisticsView(avatar, new RetGameStatsButton());
                    combinedGameView.addExternalView(statsView);
                    statsView.moveToFront();
                    combinedGameView.setNext("Game");
                    combinedGameView.setRedraw(true);
                    spawned = true;
                }
        }
        
        public void spawnLevelUp(){
            if(!spawned && avatar.getLevels() > 0){                  
            	leveledView = new LevelUpView(new LevelStat("Strength"),new LevelStat("Agility"),new LevelStat("Intellect"));
                combinedGameView.addExternalView(leveledView);
                leveledView.moveToFront();
                combinedGameView.setNext("Game");
                combinedGameView.setRedraw(true);
                spawned = true;
            }
    }
       
       
        /********************Action Listeners**********************/
    
        public class BackButtonListener implements ActionListener {
               
                public void actionPerformed(ActionEvent e) {
                    combinedGameView.setNext("Main");
                    combinedGameView.setRedraw(true);
                }
        }
        
        public class LevelUPButton implements ActionListener {
            
            public void actionPerformed(ActionEvent e) {
    			spawnLevelUp();
            }
    }
       
        public class SaveGameButton implements ActionListener {
               
                public void actionPerformed(ActionEvent e) {
                    try {
						new Game(map, avatar).save();
						reset = false;
					} catch (IOException e1) {
						reset = false;
					}
                }
        }
       
        public class RetGameButton implements ActionListener {
               
                public void actionPerformed(ActionEvent e) {
                    combinedGameView.removeExternalView(systemMenu);
                    spawned = false;
                    combinedGameView.setNext("Game");
                    combinedGameView.setRedraw(true);
                }
        }
       
       
        public class RetGameStatsButton implements ActionListener {
               
                public void actionPerformed(ActionEvent e) {
                	combinedGameView.removeExternalView(statsView);
                    spawned = false;
                    combinedGameView.setNext("Game");
                    combinedGameView.setRedraw(true);
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
        
        public class LevelStat implements ActionListener {
        	String stat = "";
        	public LevelStat(String s){
        		stat = s; 
        	}
            public void actionPerformed(ActionEvent e) {
            	avatar.setStatValue(stat, avatar.getStatValue(stat)+1);
            	avatar.setLevels(avatar.getLevels()-1);
            	combinedGameView.removeExternalView(leveledView);
                spawned = false;
                combinedGameView.setNext("Game");
                combinedGameView.setRedraw(true);
            }
    }
    
 
    public class BoardMouseListener implements MouseListener{
        // all these classes need to be defined in the MapView
           
           
        // Point of Reference needs to be added to the tileY and tileX
        // the point of reference is the point that reflects the change in the display of the map
        public Location getTileLocation(MouseEvent e){
        	Point point = map.getLocation(avatar);
            int tileY = e.getY()/Scaling.TILE_HEIGHT;
            int tileX = e.getX()/Scaling.TILE_WIDTH;
            int xOff = point.getX() + (tileX - MapView.CHARACTER_OFFSET);
            int yOff = point.getY() + (tileY - MapView.CHARACTER_OFFSET);
            return new Location(xOff,yOff);
        }
           
        public void mouseClicked(MouseEvent e) {
            Location tileLocation = this.getTileLocation(e);
            //TRANSACTION   USE get ,  if room in Inventory  then drop,  else do nothing
            // TODO  This is a Type Cast type casting is bad,  it leads to broke people on the streets and
            // corrupts governments,  please dont type cast,  Hackers love type casting. 
            // Testing Purposes for Iteration 1 only,   Implementation
            TakeableItem droppedItem = (TakeableItem) map.getTile(tileLocation).getItem();
            System.out.println(droppedItem+"  "+tileLocation);
            boolean itemIsOnAvatar = (map.getTile(tileLocation).getItem() == droppedItem) 
            	&& (map.getEntityTile(avatar) == map.getTile(tileLocation));
            if( itemIsOnAvatar){
            	if (avatar.getInventory().findAndEquip(droppedItem)){
                    map.getTile(tileLocation).dropItem();
            	}
        	}
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) { }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }
    
    public class DeathLevelCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(avatar.getStatValue("Lives") == 0){
				 reset = true;
				 combinedGameView.setNext("Main");
	             combinedGameView.setRedraw(true);
			}
			else if(avatar.getStatValue("HP") == 0){
				avatar.setStatValue("Lives", avatar.getStatValue("Lives")-1);
				avatar.setStatValue("HP", avatar.getStatValue("Life"));
			}
			else if(yourLvl != avatar.getStatValue("Level")){
				avatar.setLevels(avatar.getLevels()+avatar.getStatValue("Level")-yourLvl);
				yourLvl = avatar.getStatValue("Level");
			}
		}
	}
       
}
