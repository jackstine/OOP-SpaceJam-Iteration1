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
		
		@Override
		public void keyPressed(KeyEvent e) {
			Location avatarLocation = this.getAvatarLocation();
			Location temp= new Location(avatarLocation.getX(),avatarLocation.getY());
			//System.out.println(e.getKeyCode()); used for debugging
			if(!active){
				return;
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1 || e.getKeyCode()==KeyEvent.VK_1){
				
				if(map.getTile(temp.addLocation(-1,1)).isPassable()){
				avatarLocation.add(SOUTHWEST);
				map.setDeltaX((-1)*Scaling.TILE_SCALE.getX());
				map.setDeltaY(Scaling.TILE_SCALE.getX());
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
				
				
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD2 || e.getKeyCode()==KeyEvent.VK_2){
				
				if(map.getTile(temp.addLocation(0,1)).isPassable()){
				avatarLocation.add(SOUTH);
				map.setDeltaX(0);
				map.setDeltaY(Scaling.TILE_SCALE.getX());
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD3 || e.getKeyCode()==KeyEvent.VK_3){
				
				if(map.getTile(temp.addLocation(1,1)).isPassable()){
				avatarLocation.add(SOUTHEAST);
				map.setDeltaX(Scaling.TILE_SCALE.getX());
				map.setDeltaY(Scaling.TILE_SCALE.getX());
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD6 || e.getKeyCode()==KeyEvent.VK_6){
				
				if(map.getTile(temp.addLocation(1,0)).isPassable()){
				avatarLocation.add(EAST);
				map.setDeltaX(Scaling.TILE_SCALE.getX());
				map.setDeltaY(0);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD9 || e.getKeyCode()==KeyEvent.VK_9){
				
				if(map.getTile(temp.addLocation(1,-1)).isPassable()){
				avatarLocation.add(NORTHEAST);
				map.setDeltaX(Scaling.TILE_SCALE.getX()); //changed this
				map.setDeltaY((-1)*Scaling.TILE_SCALE.getX());
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD8 || e.getKeyCode()==KeyEvent.VK_8){
				
				if(map.getTile(temp.addLocation(0,-1)).isPassable()==true){
				avatarLocation.add(NORTH);
				map.setDeltaX(0);
				map.setDeltaY((-1)*Scaling.TILE_SCALE.getX());
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD7 || e.getKeyCode()==KeyEvent.VK_7){
				
				if(map.getTile(temp.addLocation(-1,-1)).isPassable()){
				avatarLocation.add(NORTHWEST);
				map.setDeltaX((-1)*Scaling.TILE_SCALE.getX());
				map.setDeltaY((-1)*Scaling.TILE_SCALE.getX());
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD4 || e.getKeyCode()==KeyEvent.VK_4){
			
				if(map.getTile(temp.addLocation(-1,0)).isPassable()){
				avatarLocation.add(WEST);
				map.setDeltaX((-1)*Scaling.TILE_SCALE.getX());
				map.setDeltaY(0);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
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
