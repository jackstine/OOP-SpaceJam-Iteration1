import java.awt.event.WindowEvent;

import controller.ViewController;



public class RunGame {
	private ViewController start;
	
	public static void main(String[] args) {
		RunGame game = new RunGame();
		while(game.start.getCurrent().getNext() != "Quit"){
			game.start.display();
		}
		game.start.getFrame().dispatchEvent(new WindowEvent(game.start.getFrame(), WindowEvent.WINDOW_CLOSING));
	}
	
	public RunGame(){
		start = new ViewController();
	}
}
