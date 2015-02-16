package controller;

import model.Avatar;
import model.EffectHandler;
import model.Game;
import model.GameMap;
import model.Item;
import model.Location;
import model.QuestHandler;
import model.Tile;
import model.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.Timer;

import utilities.Scaling;
import utilities.Directions;


//public class MapViewController extends JFrame{
public class MapViewController{
	private static final long serialVersionUID = 1L;
	private GameMap map ;
	private Avatar avatar;
	private boolean active;
	private GameController game;
	private EffectHandler effectHandler;
	private QuestHandler questHandler;
	//public BufferedImage image;
	private boolean keyReleased;
	
	public MapViewController(GameController game,JFrame frame){ //added GameMap here
		frame.addKeyListener(new CharacterKeyboardController());
		this.avatar = game.getGame().getAvatar();
		this.map= game.getGame().getMap();
		this.game = game;
		effectHandler= new EffectHandler(avatar);
		questHandler = new QuestHandler(avatar);
		map.setAvatar(avatar);
		//image=avatar.loadImage();
		//TODO fir good reasons
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
		
		HashSet<Integer> pressedKeys = new HashSet<Integer>();
		
		public CharacterKeyboardController(){
	           new Timer(1000, new ActionListener(){
	                @Override
	                public void actionPerformed(ActionEvent arg0) {
	                    String keysString = "";
	                    if(!pressedKeys.isEmpty()){
	                        Iterator<Integer> i = pressedKeys.iterator();
	                        while(i.hasNext()){
	                            keysString += i.next() + ",";
	                        }
	                    } 
	                    System.out.println(keysString);
	                }
	            }).start();	
		}
		
		public Location getAvatarLocation(){
			return map.getLocation(avatar);
		}
		
		public void move(Point point, int direction){
			avatar.setDirection(direction);
			if(map.getTile(temp.addLocation(point)).isPassable()){
				avatarLocation.add(point);
				map.setDelta(point);
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
			avatarLocation = this.getAvatarLocation();
			temp= new Location(avatarLocation.getX(),avatarLocation.getY());
			
			int key = e.getKeyCode();
			//System.out.println(e.getKeyCode()); used for debugging
			if(!active){
				return;
			}
			if(key==KeyEvent.VK_NUMPAD1 || key==KeyEvent.VK_1){
				this.move(SOUTHWEST, Directions.SOUTHWEST);
			}
			else if(key==KeyEvent.VK_NUMPAD2 || key==KeyEvent.VK_2 || key==KeyEvent.VK_S){
				this.move(SOUTH, Directions.SOUTH);
			}
			else if(key==KeyEvent.VK_NUMPAD3 || key==KeyEvent.VK_3){
				this.move(SOUTHEAST, Directions.SOUTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD6 || key==KeyEvent.VK_6 || key==KeyEvent.VK_D){
				this.move(EAST, Directions.EAST);
			}
			else if(key==KeyEvent.VK_NUMPAD9 || key==KeyEvent.VK_9){
				this.move(NORTHEAST, Directions.NORTHEAST);
			}
			else if(key==KeyEvent.VK_NUMPAD8 || key==KeyEvent.VK_8 || key==KeyEvent.VK_W){
				this.move(NORTH, Directions.NORTH);
			}
			else if(key==KeyEvent.VK_NUMPAD7 || key==KeyEvent.VK_7){
				this.move(NORTHWEST, Directions.NORTHWEST);
			}
			else if(key==KeyEvent.VK_NUMPAD4 || key==KeyEvent.VK_4 || key==KeyEvent.VK_A){
				this.move(WEST, Directions.WEST);
			}
			else if(key==KeyEvent.VK_NUMPAD0 || key==KeyEvent.VK_0){
				this.move(new Point(0,0), Directions.DANCE);
			}
			else if(key==KeyEvent.VK_NUMPAD5 || key==KeyEvent.VK_5){
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
			
            int keyCode = key;
            pressedKeys.add(keyCode);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			keyReleased = true;
            int keyCode = e.getKeyCode();
            pressedKeys.remove(keyCode);
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
		
	}
	/*public static void main(String[]args){
		Avatar avatar = new Avatar();
		MapViewController mv = new MapViewController(avatar);
		mv.setVisible(true);
		
		
	}*/
	
 
}
