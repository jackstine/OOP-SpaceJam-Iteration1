package Test;

import model.*;

public class TestSaveGame {
	
	public static void main(String[] args) throws Exception {
		Game game = new Game();
		System.out.println("Avatar = " + game.getAvatar().getName());
		Avatar avatar = new Avatar(new Terminator());
		avatar.setName("Arnold");
		
		game.setAvatar(avatar);
		game.save();
		game.load();
		
		System.out.println(game.getAvatar());	
	}
}
