package controller;

import model.Avatar;
import model.GameMap;
import model.Location;
import model.Tile;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


//public class MapViewController extends JFrame{
public class MapViewController{
	private static final long serialVersionUID = 1L;
	private GameMap map ;
	public Avatar avatar;
	//public BufferedImage image;
//TODO	link with the MapView
	
	public MapViewController(GameMap map, Avatar avatar,JFrame frame){ //added GameMap here
		frame.addKeyListener(new CharacterKeyboardController());
		this.avatar = avatar;
		this.map=map;
		//image=avatar.loadImage();
		
		
	}
	
	
	public class CharacterKeyboardController implements KeyListener{

	
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(e.getKeyCode()); used for debugging
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1){
				int x= map.getLocation(avatar).getX()-1;
				int y=map.getLocation(avatar).getY()+1;
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
				
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD2){
				int x= map.getLocation(avatar).getX();
				int y=map.getLocation(avatar).getY()+1;
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
				
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD3){
				int x= map.getLocation(avatar).getX()+1;
				int y=map.getLocation(avatar).getY()+1;
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
				//map.setD(100); //not complete testing moving map under
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD6){
				int x= map.getLocation(avatar).getX()+1;
				int y=map.getLocation(avatar).getY();
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD9){
				int x= map.getLocation(avatar).getX()+1;
				int y=map.getLocation(avatar).getY()-1;
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD8){
				int x= map.getLocation(avatar).getX();
				int y=map.getLocation(avatar).getY()-1;
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD7){
				int x= map.getLocation(avatar).getX()-1;
				int y=map.getLocation(avatar).getY()-1;
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD4){
				int x= map.getLocation(avatar).getX()-1;
				int y=map.getLocation(avatar).getY();
				map.updateEntityLocation(avatar, new Location(x,y));
				System.out.println(map.getLocation(avatar).toString());
			}
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
