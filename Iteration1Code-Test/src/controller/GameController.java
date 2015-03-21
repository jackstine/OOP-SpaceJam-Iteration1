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
import utilities.DeathSoundEffect;
import utilities.FriendlyDeathSoundEffect;
import utilities.SoundEffect;
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
        
        Timer statUpdater;
        
        //private GameLog log = new GameLog();
        
        
        
        public GameController(){
        	//This is needed. DON'T DELETE. We should probably make some temp game here.
        }
        
        public GameController(Game game){
        	this.world = game.getWorld();
        	this.avatar = game.getAvatar();
        	this.map = world.getMap(avatar.getCurrMap());
			combinedGameView = new CombinedGameView(map, avatar, new BoardMouseListener(avatar,world), new LevelUPButton(), new SystemsMenuButton(), new StatButtonAction());
        	this.world.setMapView(getMapView());
        	systems = new SystemsController(combinedGameView, avatar, world);
        	stats = new StatsController(combinedGameView, avatar); 
        	levelUp = new LevelUpController(combinedGameView, avatar);
        	     		
     		statUpdater = new Timer(100, new StatCheck());
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
	             avatar.makeDeathSoundEffect();
	             statUpdater.stop();
			}
			else if(avatar.getStatValue("HP") <= 0){
				avatar.setStatValue("Lives", avatar.getStatValue("Lives")-1);
				avatar.setStatValue("HP", avatar.getStatValue("Life"));
				avatar.makeDeathSoundEffect();
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
			Location killLocation = null;
			for (Entry<Entity, Location> entry : World.getMap(avatar.getCurrMap()).getEntityToLocationMap().entrySet()) {
				killLocation = null;
				Entity key = entry.getKey();
				Location loc = entry.getValue();
				if(key.getStats().getStatValue("HP") <= 0){
					killLocation = loc;
					break;
				}
			}
			if (killLocation != null)
				map.kill(killLocation);
		}
	}
    
    public void applyEffect(InfluenceSet i) {
    	i.printInfluenceSet();
    }
    
    public class BoardMouseListener implements MouseListener{
    	private MapMouseHandler handler;
    	
    	public BoardMouseListener(Avatar avatar, World world){
    		this.handler = new MapMouseHandler(world,avatar);
    	}
           
        public void mouseClicked(MouseEvent e) {
        	Location tileLocation = this.handler.getTileLocation(e);
            this.handler.pickupItem(tileLocation);
            this.handler.useSpell(tileLocation);
            if(this.handler.getEntity(tileLocation) != null){
            	avatar.writeJournal(this.handler.getEntity(tileLocation).toString() + "\n" + this.handler.getEntity(tileLocation).observation(avatar.getSkillValue("Observation"),(int)tileLocation.distance(map.getEntityLocation(avatar))));
            }
            getMapView().repaint();
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) { }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }
 
       
}
