package controller;

import model.Avatar;
import model.GameMap;

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

	
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getKeyCode());
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1){
				avatar.move(-1,1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD2){
				avatar.move(0,1);
				
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD3){
				avatar.move(1, 1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD6){
				avatar.move(+1, 0);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD9){
				avatar.move(1,-1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD8){
				avatar.move(0, -1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD7){
				avatar.move(-1, -1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD4){
				avatar.move(-1, 0);
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
