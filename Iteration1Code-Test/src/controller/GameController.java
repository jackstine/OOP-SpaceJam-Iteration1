package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.JInternalFrame;
import javax.swing.Timer;

import controller.mouse.MapMouseHandler;
import model.Game;
import model.GameMap;
import model.Location;
import model.Point;
import model.World;
import model.Entity.Avatar;
import model.Skill;
import model.occupation.Occupation;
import utilities.Scaling;
import view.CombinedGameView;
import view.ControlConfigView;
import view.LevelUpView;
import view.MapView;
import view.StatisticsView;
import view.SystemMenuView;
import view.View;
 
public class GameController {
	
		private World world;
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
        	this.world = game.getWorld();
        	this.avatar = game.getAvatar();
        	this.map = world.getMap(avatar.getCurrMap());
        	combinedGameView = new CombinedGameView(map, avatar, new BoardMouseListener(), new LevelUPButton(), new SystemsMenuButton(), new StatButtonAction());
        	statsView = new StatisticsView(avatar, new RetGameStatsButton());
        	systemMenu = new SystemMenuView(new BackButtonListener(),new SaveGameButton(), new RetGameButton(), new OpenControlConfig());
        	leveledView = new LevelUpView(genSkillListeners(avatar.getOccupation()));
        	controlConfig = new ControlConfigView(new BackButtonUIListener(), new ChangeControlListener(), new ResetControlsListener(), world.getKeySet());
        	combinedGameView.addExternalViews(systemMenu);
        	combinedGameView.addExternalViews(statsView);
        	combinedGameView.addExternalViews(leveledView);
        	combinedGameView.addExternalViews(controlConfig);
     		
     		Timer statUpdater = new Timer(100, new StatCheck());
     		statUpdater.start();
        }
       
        
       
        /********************MISC OPERATIONS**********************/
        public Map<String, ActionListener> genSkillListeners(Occupation e){
        	Map<String, ActionListener> skillmap = new HashMap<String, ActionListener>();
  			int i = 0;
  			String key;
        	for(Entry<String, Skill> entry: e.getSkills().entrySet()){
	   			 key = entry.getKey();
	   			 skillmap.put(key, new LevelStat(key));
	   			 if(i == 4) i = 0;
	   		 }
        	return skillmap;        	
        }
        
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
            	world.genDefaultKeys();
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
						new Game(world, avatar).save();
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
        	String skill = "";
        	String[] stats = {"Strength", "Intellect", "Agility", "Hardiness","Movement"};
        	Random rn = new Random();
        	public LevelStat(String skill){
        		this.skill = skill;        		
        	}
            public void actionPerformed(ActionEvent e) {
            	//avatar.setStatValue(stat, avatar.getStatValue(stat)+1);
            	int i = rn.nextInt(5);
            	String text = "Here are your random stat increases:\n";
            	avatar.setStatValue(stats[i], avatar.getStatValue(stats[i])+1);
            	text += stats[i] + "\n";
            	i = rn.nextInt(5);
            	avatar.setStatValue(stats[i], avatar.getStatValue(stats[i])+1);
            	text += stats[i]+ "\n";
            	i = rn.nextInt(5);
            	avatar.setStatValue(stats[i], avatar.getStatValue(stats[i])+1);
            	text += stats[i]+ "\n";
            	avatar.writeJournal(text);
            	
            	avatar.incSkillValue(skill);
            	avatar.setLevels(avatar.getLevels()-1);
            	combinedGameView.removeExternalView(leveledView);
                spawned = false;
                System.out.println(skill+":"+avatar.getSkillValue(skill));
                combinedGameView.setNext("Game");
                combinedGameView.setRedraw(true);
            }
    }
    
    public class BoardMouseListener implements MouseListener{
        // all these classes need to be defined in the MapView
    	private MapMouseHandler handler;
    	
    	public BoardMouseListener(){
    		this.handler = new MapMouseHandler(map,avatar);
    	}
    	
        // Point of Reference needs to be added to the tileY and tileX
        // the point of reference is the point that reflects the change in the display of the map
        private Location getTileLocation(MouseEvent e){
        	Point point = map.getLocation(avatar);
            int tileY = e.getY()/Scaling.TILE_HEIGHT;
            int tileX = e.getX()/Scaling.TILE_WIDTH;
            int xOff = point.getX() + (tileX - MapView.CHARACTER_OFFSET);
            int yOff = point.getY() + (tileY - MapView.CHARACTER_OFFSET);
            return new Location(xOff,yOff);
        }
           
        public void mouseClicked(MouseEvent e) {
        	Location tileLocation = this.getTileLocation(e);
            this.handler.pickupItem(tileLocation);
            this.handler.useSpell(tileLocation);
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) { }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }
    
    public class StatCheck implements ActionListener {
    	private int yourLvl;
    	private String currMap;
    	public StatCheck(){
    		yourLvl = avatar.getStatValue("Level"); 
    		currMap=avatar.getCurrMap();
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
			else if(!currMap.equals(avatar.getCurrMap())){
				currMap=avatar.getCurrMap();
				combinedGameView.changeMap(world.getMap(currMap));
			}
			statsView.Updatetable(avatar);
			combinedGameView.updateStatus();
		}
	}
    
 
       
}
