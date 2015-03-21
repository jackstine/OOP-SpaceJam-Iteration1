package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map.Entry;

import javax.swing.Timer;

import controller.mouse.MapMouseHandler;
import model.Game;
import model.GameMap;
import model.InfluenceSet;
import model.Location;
import model.World;
import model.entity.Avatar;
import model.entity.Entity;
import view.CombinedGameView;
import view.ControlField;
import view.MapView;
import view.View;
 
public class GameController {
	
		private World world;
		private GameMap map;
		private Avatar avatar;
		private boolean reset = false;
        
        private SystemsController systems;
        private StatsController stats;
        private LevelUpController levelUp;
        
        private CombinedGameView combinedGameView;
        
        //private GameLog log = new GameLog();
        
        
        
        public GameController(){
        	//This is needed. DON'T DELETE. We should probably make some temp game here.
        }
        
        public GameController(Game game){
        	this.world = game.getWorld();
        	this.avatar = game.getAvatar();
        	this.map = world.getMap(avatar.getCurrMap());
			combinedGameView = new CombinedGameView(map, avatar, new BoardMouseListener(avatar,map), new LevelUPButton(), new SystemsMenuButton(), new StatButtonAction());
        	this.world.setMapView(getMapView());
        	systems = new SystemsController(combinedGameView, avatar, world);
        	stats = new StatsController(combinedGameView, avatar); 
        	levelUp = new LevelUpController(combinedGameView, avatar);
        	     		
     		Timer statUpdater = new Timer(100, new StatCheck());
     		statUpdater.start();
        }  
        
        public MapView getMapView(){
        	return combinedGameView.getMapView();
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
                   
        /********************Action Listeners**********************/ 
      
        public class SystemsMenuButton implements ActionListener { //Systems
            public void actionPerformed(ActionEvent e) {
            	systems.spawnSystems();
            }
        }     
       
        public class StatButtonAction implements ActionListener {//Statistics
            public void actionPerformed(ActionEvent e) {
                stats.spawnStats();
            }
        }
        
        public class LevelUPButton implements ActionListener {//LevelUP
            
            public void actionPerformed(ActionEvent e) {
            	levelUp.spawnLevelUp();
    			//applyEffect(new RadialInfluenceSet(map, map.getEntityTile(avatar),0,0));
            }
        }
    
    public class StatCheck implements ActionListener {
    	private int yourLvl;
    	private String currMap;
    	public StatCheck(){
    		yourLvl = avatar.getStatValue("Level"); 
    		currMap = avatar.getCurrMap();
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
				currMap = avatar.getCurrMap();
				map = world.getMap(currMap);
				combinedGameView.changeMap(map);
			}
			stats.updatetable();
			combinedGameView.updateStatus();
			for (Entry<Entity, Location> entry : map.getEntityToLocationMap().entrySet()) {
				Entity key = entry.getKey();
				Location loc = entry.getValue();
//				System.out.println();
//            	System.out.println();
//            	System.out.println();
//            	System.out.println("STAT CHECKING STAT CHECKING STAT CHECKING STAT CHECKING");
//				System.out.println(key + " " + key.getHP() + "   HP: " + key.getStats().getStatValue("HP"));
//				System.out.println(key.getClass().getName() + "@" + Integer.toHexString(key.hashCode()));
//				System.out.println(loc);
				//System.out.println(key + " " + key.getHP() + "   HP: " + key.getStats().getStatValue("HP"));
				if(key.getStats().getStatValue("HP") <= 0){
					System.out.println("KILLED IT");
					map.kill(loc);
					break;
				}
			}
		}
	}
    
    public void applyEffect(InfluenceSet i) {
    	i.printInfluenceSet();
    }
    
    public class BoardMouseListener implements MouseListener{
    	private MapMouseHandler handler;
    	
    	public BoardMouseListener(Avatar avatar, GameMap map){
    		this.handler = new MapMouseHandler(map,avatar);
    	}
           
        public void mouseClicked(MouseEvent e) {
        	// thing here is we would like to separate pickup items and using a spell
        	// when clicking
        	Location tileLocation = this.handler.getTileLocation(e);
        	System.out.println("LOCATION CLICKED   " + tileLocation);
            this.handler.pickupItem(tileLocation);
            this.handler.useSpell(tileLocation);
            if(this.handler.getEntity(tileLocation) != null){
//            	System.out.println();
//            	System.out.println();
//            	System.out.println("MOUSE CLICKING MOUSE CLICKING MOUSE CLICKING MOUSE CLICKING");
            	avatar.writeJournal(this.handler.getEntity(tileLocation).toString() + "\n" + this.handler.getEntity(tileLocation).observation(avatar.getSkillValue("Observation"),(int)tileLocation.distance(map.getEntityLocation(avatar))));
//            	System.out.println(this.handler.getEntity(tileLocation).getClass().getName() + "@" + Integer.toHexString(this.handler.getEntity(tileLocation).hashCode()));
//            	if(this.handler.getEntity(tileLocation).getStats().getStatValue("HP") <= 0){
//					map.kill(tileLocation);
//				}
            }
            getMapView().repaint();
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) { }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }
 
       
}
