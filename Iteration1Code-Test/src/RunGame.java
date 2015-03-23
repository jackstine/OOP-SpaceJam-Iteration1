import utilities.BackgroundMusicPlayer;
import utilities.SpaceJamBackgroundMusicPlayer;
import controller.ViewController;



public class RunGame {
	private ViewController start;
	private static final boolean MUSIC = true;
	
	public static void main(String[] args) {
		RunGame game = new RunGame();
		game.start.display();
		if (MUSIC) {
			//ALTERNATIVELY: USE A SpaceJamBackgroundPlayer to play Space Jam
			BackgroundMusicPlayer player = new BackgroundMusicPlayer();
		}
	}
	
	public RunGame(){
		start = new ViewController();
	}
}
