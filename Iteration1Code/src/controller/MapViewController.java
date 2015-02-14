package controller;

import model.Avatar;
import model.Game;
import model.GameMap;
import model.Item;
import model.Location;
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


//public class MapViewController extends JFrame{
public class MapViewController{
	private static final long serialVersionUID = 1L;
	private GameMap map ;
	private Avatar avatar;
	private boolean active;
	private GameController game;
	//public BufferedImage image;
	
	public MapViewController(GameController game,JFrame frame){ //added GameMap here
		frame.addKeyListener(new CharacterKeyboardController());
		this.avatar = game.getGame().getAvatar();
		this.map= game.getGame().getMap();
		this.game = game;
		//image=avatar.loadImage();
		
		
		//TODO fir good reasons
		this.active = false;
		
		
	}
	
	public void setActive(boolean active){
		this.active =  active;
	}
	
	
	public class MapMouseListener implements MouseListener{


		// all these classes need to be defined in the MapView
		public void mouseClicked(MouseEvent e) {
			int tileY = e.getY()/Scaling.TILE_SCALE.getX();
			int tileX = e.getX()/Scaling.TILE_SCALE.getX();
			Location tileLocation = new Location(tileX,tileY);
			
			//TRANSACTION   USE get ,  if room in Inventory  then drop,  else do nothing
			Item droppedItem = map.getTile(tileLocation).getItem();
			System.out.println(droppedItem+"  "+tileLocation);
			
			//Inventory View and Game Map are needed
			// Logic is in comments below
			
//			if (inventoryView.getInventory().findAndEquip(droppedItem)){
//				map.getTile(tileLocation).dropItem();
//				tile.repaint();
//				frame.repaint();
//			}
//			tile.repaint();
//			this.repaint();
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
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
		
		public void move(Point point){
			if(map.getTile(temp.addLocation(point)).isPassable()){
				avatarLocation.add(point);
				map.setDelta(point);
			}
			System.out.println(map.getTile(avatarLocation).getTerrain());	
		}
		
		private Location avatarLocation;
		private Location temp;
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			avatarLocation = this.getAvatarLocation();
			temp= new Location(avatarLocation.getX(),avatarLocation.getY());
			//System.out.println(e.getKeyCode()); used for debugging
			if(!active){
				return;
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1 || e.getKeyCode()==KeyEvent.VK_1){
				this.move(SOUTHWEST);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD2 || e.getKeyCode()==KeyEvent.VK_2){
				this.move(SOUTH);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD3 || e.getKeyCode()==KeyEvent.VK_3){
				this.move(SOUTHEAST);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD6 || e.getKeyCode()==KeyEvent.VK_6){
				this.move(EAST);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD9 || e.getKeyCode()==KeyEvent.VK_9){
				this.move(NORTHEAST);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD8 || e.getKeyCode()==KeyEvent.VK_8){
				this.move(NORTH);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD7 || e.getKeyCode()==KeyEvent.VK_7){
				this.move(NORTHWEST);
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD4 || e.getKeyCode()==KeyEvent.VK_4){
				this.move(WEST);
			}
			else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
				game.spawnSystems();
			}
			map.updateEntityLocation(avatar, avatarLocation);
			System.out.println(map.getLocation(avatar).toString());
			
            int keyCode = e.getKeyCode();
            pressedKeys.add(keyCode);
		}

		@Override
		public void keyReleased(KeyEvent e) {
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
