package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.GameMap;
import model.Point;
import model.World;
import model.Entity.Avatar;
import utilities.Directions;
import view.MapView;


//public class MapViewController extends JFrame{
public class MapViewController{
	private GameMap currMap ;
	private World world;
	private Avatar avatar;
	private boolean active;
	private GameController game;
	//public BufferedImage image;
	private boolean keyReleased;
	private Map<String, Integer> keySet;
	private MapView mapView;
	
	public MapViewController(World world,Avatar avatar,JFrame frame,MapView mapView){ //added GameMap here
		this.mapView = mapView;
		frame.addKeyListener(new CharacterKeyboardController(avatar,world,mapView));
		this.avatar = avatar;
		this.world=world;
		
		this.keySet = world.getKeySet();
		world.setAvatar(avatar);
		//image=avatar.loadImage();
		//TODO fir good reasons
		this.active = false;
		this.keyReleased = true;
	}
	
	public MapViewController(){ //Don't use this, but don't delete it either
		this.avatar = null;
		this.active = false;
		this.keyReleased = true;
	}
	
	public void setActive(boolean active){
		this.active =  active;
	}
	
	public class CharacterKeyboardController implements KeyListener{
		
		private final int baseDelay = 5000;
		private final int developmentDelay = 0;
		private Timer timer;
		
		private MovementController movement;
		
		public CharacterKeyboardController(Avatar avatar, World world, MapView mapView){
			this.movement = new MovementController(avatar, world, mapView);
			
			if(avatar != null){
				// TODO change the timer to baseDelay when issuing product
				timer = new Timer(developmentDelay/avatar.getStatValue("Movement"), new ActionListener(){
		            @Override
		            public void actionPerformed(ActionEvent arg0) {
		                keyReleased = true;
		                SyncDelay();	                
		            }
		        });
				timer.start();
			}
		}
		
		public void SyncDelay(){
			if(timer.getDelay() != baseDelay/avatar.getStatValue("Movement")){
            	timer.setDelay(baseDelay/avatar.getStatValue("Movement"));
            	avatar.writeJournal("Just updated movment speed:" + timer.getDelay());
            }
		}
		
		public void keyPressed(KeyEvent e) {
			if(keyReleased == false) return;
			keyReleased = false;
			//timer.start();
			
			int key = e.getKeyCode();
			//System.out.println(e.getKeyCode()); used for debugging
			if(!active){
				return;
			}
			if(key == KeyEvent.VK_NUMPAD1  ||key == keySet.get("SOUTHWEST")){
				this.movement.move(MovementController.SOUTHWEST, Directions.SOUTHWEST);
			}
			else if(key == KeyEvent.VK_NUMPAD2  || key==keySet.get("SOUTH")){
				this.movement.move(MovementController.SOUTH, Directions.SOUTH);
			}
			else if(key==KeyEvent.VK_NUMPAD3 || key==keySet.get("SOUTHEAST")){
				this.movement.move(MovementController.SOUTHEAST, Directions.SOUTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD6 || key==keySet.get("EAST")){
				this.movement.move(MovementController.EAST, Directions.EAST);
			}
			else if(key==KeyEvent.VK_NUMPAD9 || key==keySet.get("NORTHEAST")){
				this.movement.move(MovementController.NORTHEAST, Directions.NORTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD8 || key==keySet.get("NORTH")){
				this.movement.move(MovementController.NORTH, Directions.NORTH);
			}
			else if(key==KeyEvent.VK_NUMPAD7 || key==keySet.get("NORTHWEST")){
				this.movement.move(MovementController.NORTHWEST, Directions.NORTHWEST);
			}
			else if(key==KeyEvent.VK_NUMPAD4 || key==keySet.get("WEST")){
				this.movement.move(MovementController.WEST, Directions.WEST);
			}
			else if(key==KeyEvent.VK_NUMPAD0 || key==keySet.get("DANCE1")){
				this.movement.move(new Point(0,0), Directions.DANCE);
			}
			else if(key==KeyEvent.VK_NUMPAD5 || key==keySet.get("DANCE2")){
				this.movement.move(new Point(0,0), Directions.CENTRAL);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
}
