package controller;

import model.Avatar;
import model.GameMap;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class MapViewController extends JFrame{
	private static final long serialVersionUID = 1L;
	private GameMap map ;
	public Avatar avatar;
//TODO	link with the MapView
	
	MapViewController(Avatar avatar){
		this.addKeyListener(new CharacterKeyboardController());
		this.avatar = avatar;
	}
	
	
	public class CharacterKeyboardController implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyCode());
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD1){
				avatar.move(-1,-1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD2){
				avatar.move(-1, 0);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD3){
				avatar.move(+1, -1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD6){
				avatar.move(+1, 0);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD9){
				avatar.move(+1,+1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD8){
				avatar.move(0, +1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD7){
				avatar.move(1, 1);
			}
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD4){
				avatar.move(-1, 0);
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	}
	public static void main(String[]args){
		Avatar avatar = new Avatar();
		MapViewController mv = new MapViewController(avatar);
		mv.setVisible(true);
		
		
	}
	
 
}
