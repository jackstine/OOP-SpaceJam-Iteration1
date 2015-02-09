import java.awt.event.WindowEvent;


public class RunGame {
	private ViewController start;
	
	public static void main(String[] args) {
		RunGame game = new RunGame();
		while(game.start.getCurrent().getNext() != "Quit"){
			game.start.run();
		}
		game.start.getFrame().dispatchEvent(new WindowEvent(game.start.getFrame(), WindowEvent.WINDOW_CLOSING));
	}
	
	public RunGame(){
		start = new ViewController();
	}

}
