import utilities.BackgroundMusicPlayer;
import controller.ViewController;



public class RunGame {
	private ViewController start;
	private static final boolean MUSIC = false;
	
	public static void main(String[] args) {
		RunGame game = new RunGame();
		game.start.display();
		if (MUSIC) {
			BackgroundMusicPlayer player = new BackgroundMusicPlayer();
		}
	}
	
	public RunGame(){
		start = new ViewController();
	}
}
