import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Timer;

import controller.ViewController;



public class RunGame {
	private ViewController start;
	
	public static void main(String[] args) {
		RunGame game = new RunGame();
		game.start.display();
	}
	
	public RunGame(){
		start = new ViewController();
	}
}
