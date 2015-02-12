package controller;

import model.Avatar;
import model.GameMap;
import model.Point;

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
	
	public MapViewController(Avatar avatar,JFrame frame){
		frame.addKeyListener(new CharacterKeyboardController());
		this.avatar = avatar;
		//image=avatar.loadImage();
		
		
	}
	
	
	public class CharacterKeyboardController implements KeyListener{
		private final Point NORTH = new Point(0,1);
		private final Point SOUTH = new Point(0,-1);
		private final Point WEST = new Point(-1,0);
		private final Point EAST = new Point(1,0);
		private final Point NORTHEAST = new Point(1,1);
		private final Point SOUTHEAST = new Point(1,-1);
		private final Point NORTHWEST = new Point(-1,1);
		private final Point SOUTHWEST = new Point(-1,-1);
	
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getKeyCode());
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1 && e.getKeyCode()==KeyEvent.VK_1){
				avatar.move(SOUTHWEST);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD2 && e.getKeyCode()==KeyEvent.VK_2){
				avatar.move(SOUTH);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD3 && e.getKeyCode()==KeyEvent.VK_3){
				avatar.move(SOUTHEAST);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD6 && e.getKeyCode()==KeyEvent.VK_6){
				avatar.move(EAST);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD9 && e.getKeyCode()==KeyEvent.VK_9){
				avatar.move(NORTHEAST);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD8 && e.getKeyCode()==KeyEvent.VK_8){
				avatar.move(NORTH);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD7 && e.getKeyCode()==KeyEvent.VK_7){
				avatar.move(NORTHWEST);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD4 && e.getKeyCode()==KeyEvent.VK_4){
				avatar.move(WEST);
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
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
