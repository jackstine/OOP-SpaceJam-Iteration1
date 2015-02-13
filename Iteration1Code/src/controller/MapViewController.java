package controller;

import model.Avatar;
import model.Game;
import model.GameMap;
import model.Location;
import model.Tile;
import model.Point;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


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
	
	
	public class CharacterKeyboardController implements KeyListener{
		private final Point NORTH = new Point(0,-1);
		private final Point SOUTH = new Point(0,1);
		private final Point SOUTHWEST = new Point(-1,1);
		private final Point NORTHWEST = new Point(-1,-1);
		private final Point WEST = new Point(-1,0);
		private final Point NORTHEAST = new Point(1,-1);
		private final Point SOUTHEAST = new Point(1,1);
		private final Point EAST = new Point(1,0);
		
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
				map.setDeltaX((-1)*Tile.SCALE);
				map.setDeltaY(Tile.SCALE);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
				
				
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD2 || e.getKeyCode()==KeyEvent.VK_2){
				
				if(map.getTile(temp.addLocation(0,1)).isPassable()){
				avatarLocation.add(SOUTH);
				map.setDeltaX(0);
				map.setDeltaY(Tile.SCALE);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD3 || e.getKeyCode()==KeyEvent.VK_3){
				
				if(map.getTile(temp.addLocation(1,1)).isPassable()){
				avatarLocation.add(SOUTHEAST);
				map.setDeltaX(Tile.SCALE);
				map.setDeltaY(Tile.SCALE);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD6 || e.getKeyCode()==KeyEvent.VK_6){
				
				if(map.getTile(temp.addLocation(1,0)).isPassable()){
				avatarLocation.add(EAST);
				map.setDeltaX(Tile.SCALE);
				map.setDeltaY(0);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD9 || e.getKeyCode()==KeyEvent.VK_9){
				
				if(map.getTile(temp.addLocation(1,-1)).isPassable()){
				avatarLocation.add(NORTHEAST);
				map.setDeltaX(Tile.SCALE); //changed this
				map.setDeltaY((-1)*Tile.SCALE);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD8 || e.getKeyCode()==KeyEvent.VK_8){
				
				if(map.getTile(temp.addLocation(0,-1)).isPassable()==true){
				avatarLocation.add(NORTH);
				map.setDeltaX(0);
				map.setDeltaY((-1)*Tile.SCALE);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD7 || e.getKeyCode()==KeyEvent.VK_7){
				
				if(map.getTile(temp.addLocation(-1,-1)).isPassable()){
				avatarLocation.add(NORTHWEST);
				map.setDeltaX((-1)*Tile.SCALE);
				map.setDeltaY((-1)*Tile.SCALE);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_NUMPAD4 || e.getKeyCode()==KeyEvent.VK_4){
			
				if(map.getTile(temp.addLocation(-1,0)).isPassable()){
				avatarLocation.add(WEST);
				map.setDeltaX((-1)*Tile.SCALE);
				map.setDeltaY(0);
				}
				System.out.println(map.getTile(avatarLocation).getTerrain());
			}
			else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
				game.spawnSystems();
			}
			map.updateEntityLocation(avatar, avatarLocation);
			System.out.println(map.getLocation(avatar).toString());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			//map.setD(0);  //not done
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/*public static void main(String[]args){
		Avatar avatar = new Avatar();
		MapViewController mv = new MapViewController(avatar);
		mv.setVisible(true);
		
		
	}*/
	
 
}
