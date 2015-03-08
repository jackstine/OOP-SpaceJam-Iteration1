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
import view.ControlConfigView;
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
        
        private CombinedGameView combinedGameView = null;
        private JInternalFrame systemMenu;
        private StatisticsView statsView;
        private JInternalFrame leveledView;
        private ControlConfigView controlConfig;
        
        
        public GameController(){
        	//This is needed. DON'T DELETE. We should probably make some temp game here.
        }
        
        public GameController(Game game){
        	this.map = game.getMap();
        	this.avatar = game.getAvatar();
        	combinedGameView = new CombinedGameView(map, avatar, new BoardMouseListener(), new LevelUPButton(), new SystemsMenuButton(), new StatButtonAction());
        	statsView = new StatisticsView(avatar, new RetGameStatsButton());
        	systemMenu = new SystemMenuView(new BackButtonListener(),new SaveGameButton(), new RetGameButton(), new OpenControlConfig());
        	leveledView = new LevelUpView(new LevelStat("Strength"),new LevelStat("Agility"),new LevelStat("Intellect"));
        	controlConfig = new ControlConfigView(new BackButtonUIListener(), new ChangeControlListener(), new ResetControlsListener(), map.getKeySet());
        	
        	combinedGameView.addExternalViews(systemMenu);
        	combinedGameView.addExternalViews(statsView);
        	combinedGameView.addExternalViews(leveledView);
        	combinedGameView.addExternalViews(controlConfig);
     		
     		Timer statUpdater = new Timer(100, new StatCheck());
     		statUpdater.start();
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
            	systemMenu.setVisible(true);
                systemMenu.moveToFront();
                spawned = true;
            }
        }
        
        public void spawnStats(){
            if(!spawned){
            	statsView.setVisible(true);
                statsView.moveToFront();
                spawned = true;
            }
        }
        public void spawnLevelUp(){
            if(!spawned && avatar.getLevels() > 0){
            	leveledView.setVisible(true);
                leveledView.moveToFront();
                spawned = true;
            }
        }
        
        public void spawnControlConfig(){
        	controlConfig.setVisible(true);
            controlConfig.moveToFront();
        }
       
       
        /********************Action Listeners**********************/
        
        
        
        public class BackButtonUIListener implements ActionListener {//ControlConfig
            
            public void actionPerformed(ActionEvent e) {
            	spawned = false;
            	combinedGameView.removeExternalView(controlConfig);
            	combinedGameView.setNext("Game");
                combinedGameView.setRedraw(true);
            	spawnSystems();
            }
        }
        
        public class ChangeControlListener implements ActionListener {//ControlConfig
            public void actionPerformed(ActionEvent e) {
            	controlConfig.BindKey();
            }
        }
        
        public class ResetControlsListener implements ActionListener {//ControlConfig
            public void actionPerformed(ActionEvent e) {
            	map.genDefaultKeys();
            	controlConfig.reset();
            }
        }
        
        
        public class OpenControlConfig implements ActionListener { //Systems
            public void actionPerformed(ActionEvent e) {
            	spawnControlConfig();
            	combinedGameView.removeExternalView(systemMenu);
            	combinedGameView.setNext("Game");
                combinedGameView.setRedraw(true);
            }
        }
        
        public class BackButtonListener implements ActionListener {//Systems
               
                public void actionPerformed(ActionEvent e) {
                    combinedGameView.setNext("Main");
                    combinedGameView.setRedraw(true);
                }
        }
       
        public class SaveGameButton implements ActionListener {//Systems
               
                public void actionPerformed(ActionEvent e) {
                    try {
						new Game(map, avatar).save();
						reset = false;
					} catch (IOException e1) {
						reset = false;
					}
                }
        }
       
        public class RetGameButton implements ActionListener {//Systems
               
                public void actionPerformed(ActionEvent e) {
                	combinedGameView.removeExternalView(systemMenu);
                    spawned = false;
                    combinedGameView.setNext("Game");
                    combinedGameView.setRedraw(true);
                }
        }
        
        public class SystemsMenuButton implements ActionListener { //Systems
            public void actionPerformed(ActionEvent e) {
                    spawnSystems();
            }
        }
       
       
        public class RetGameStatsButton implements ActionListener {//Statistics
               
                public void actionPerformed(ActionEvent e) {
                	combinedGameView.removeExternalView(statsView);
                    spawned = false;
                    combinedGameView.setNext("Game");
                    combinedGameView.setRedraw(true);
                }
        }
       
        public class StatButtonAction implements ActionListener {//Statistics
                public void actionPerformed(ActionEvent e) {
                        spawnStats();
                }
        }
        
        public class LevelUPButton implements ActionListener {//LevelUP
            
            public void actionPerformed(ActionEvent e) {
    			spawnLevelUp();
            }
        }
        
        public class LevelStat implements ActionListener { //LevelUP
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
    
    public class StatCheck implements ActionListener {
    	private int yourLvl;
    	public StatCheck(){
    		yourLvl = avatar.getStatValue("Level"); 
    	}
		public void actionPerformed(ActionEvent e) {
			if(avatar.getStatValue("Lives") <= 0){
				 reset = true;
				 combinedGameView.setNext("Main");
	             combinedGameView.setRedraw(true);
			}
			else if(avatar.getStatValue("HP") <= 0){
				avatar.setStatValue("Lives", avatar.getStatValue("Lives")-1);
				avatar.setStatValue("HP", avatar.getStatValue("Life"));
			}
			else if(yourLvl != avatar.getStatValue("Level")){
				avatar.setLevels(avatar.getLevels()+avatar.getStatValue("Level")-yourLvl);
				yourLvl = avatar.getStatValue("Level");
			}
			statsView.Updatetable(avatar);
			combinedGameView.updateStatus();
		}
	}
       
}
