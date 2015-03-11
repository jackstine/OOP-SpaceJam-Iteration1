package controller;

import model.EffectHandler;
import model.GameMap;
import model.Location;
import model.QuestHandler;
import model.Point;
import model.Entity.Avatar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.Timer;

import utilities.Directions;
import view.View;


//public class MapViewController extends JFrame{
public class MapViewController{
	private GameMap map ;
	private Avatar avatar;
	private boolean active;
	private GameController game;
	private EffectHandler effectHandler;
	private QuestHandler questHandler;
	//public BufferedImage image;
	private boolean keyReleased;
	private Map<String, Integer> keySet;
	
	public MapViewController(GameMap map,Avatar avatar,JFrame frame){ //added GameMap here
		frame.addKeyListener(new CharacterKeyboardController(avatar));
		this.avatar = avatar;
		this.map= map;
		this.keySet = map.getKeySet();
		effectHandler= new EffectHandler(avatar);
		questHandler = new QuestHandler(avatar);
		map.setAvatar(avatar);
		//image=avatar.loadImage();
		//TODO fir good reasons
		this.active = false;
		this.keyReleased = true;
	}
	
	public MapViewController(){ //Don't use this, but don't delete it either
		this.avatar = null;
		this.map= null;
		this.active = false;
		this.keyReleased = true;
	}
	
	public void setActive(boolean active){
		this.active =  active;
	}
	
	public class CharacterKeyboardController implements KeyListener{
		private final Point NORTH = new Point(0,-1);
		private final Point SOUTH = new Point(0,1);
		private final Point SOUTHWEST = new Point(-1,1);
		private final Point NORTHWEST = new Point(-1,-1);
		private final Point WEST = new Point(-1,0);
		private final Point NORTHEAST = new Point(1,-1);
		private final Point SOUTHEAST = new Point(1,1);
		private final Point EAST = new Point(1,0);
		
		public CharacterKeyboardController(Avatar avatar){
			Timer timer = new Timer(25*avatar.getStatValue("Movement"), new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                keyReleased = true;
	            }
	        });
			timer.start();
		}
		
		
		public Location getAvatarLocation(){
			return map.getLocation(avatar);
		}
		
		public void move(Point point, int direction){
			avatar.setDirection(direction);
			if(map.getTile(temp.addLocation(point)).isPassable()){
				avatarLocation.add(point);
				questHandler.apply(map.getTile(avatarLocation));
				effectHandler.apply(map.getTile(avatarLocation));
				
			}
			System.out.println(map.getTile(avatarLocation).getTerrain());	
		}
		
		private Location avatarLocation;
		private Location temp;
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(keyReleased == false) return;
			keyReleased = false;
			//timer.start();
			avatarLocation = this.getAvatarLocation();
			temp= new Location(avatarLocation.getX(),avatarLocation.getY());
			
			int key = e.getKeyCode();
			//System.out.println(e.getKeyCode()); used for debugging
			if(!active){
				return;
			}
			if(key == KeyEvent.VK_NUMPAD1  ||key == keySet.get("SOUTHWEST")){
				this.move(SOUTHWEST, Directions.SOUTHWEST);
			}
			else if(key == KeyEvent.VK_NUMPAD2  || key==keySet.get("SOUTH")){
				this.move(SOUTH, Directions.SOUTH);
			}
			else if(key==KeyEvent.VK_NUMPAD3 || key==keySet.get("SOUTHEAST")){
				this.move(SOUTHEAST, Directions.SOUTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD6 || key==keySet.get("EAST")){
				this.move(EAST, Directions.EAST);
			}
			else if(key==KeyEvent.VK_NUMPAD9 || key==keySet.get("NORTHEAST")){
				this.move(NORTHEAST, Directions.NORTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD8 || key==keySet.get("NORTH")){
				this.move(NORTH, Directions.NORTH);
			}
			else if(key==KeyEvent.VK_NUMPAD7 || key==keySet.get("NORTHWEST")){
				this.move(NORTHWEST, Directions.NORTHWEST);
			}
			else if(key==KeyEvent.VK_NUMPAD4 || key==keySet.get("WEST")){
				this.move(WEST, Directions.WEST);
			}
			else if(key==KeyEvent.VK_NUMPAD0 || key==keySet.get("DANCE1")){
				this.move(new Point(0,0), Directions.DANCE);
			}
			else if(key==KeyEvent.VK_NUMPAD5 || key==keySet.get("DANCE2")){
				this.move(new Point(0,0), Directions.CENTRAL);
			}
			else if(key==KeyEvent.VK_ESCAPE){
				game.spawnSystems();
			}
			else if(key==KeyEvent.VK_C){
				game.spawnStats();
			}
			map.updateEntityLocation(avatar, avatarLocation);
			System.out.println(map.getLocation(avatar).toString());
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
}
