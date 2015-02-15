package Test;

import model.*;

public class TestSaveGame {
	
	public static void main(String[] args) throws Exception {
		Game game = new Game();
		//System.out.println("Avatar = " + game.getAvatar().getName());
		//System.out.println(game.getAvatar().getInventory());
		Avatar avatar = new Avatar(new Terminator());
		avatar.setName("Arnold");
		avatar.getInventory().findAndEquip(new Armor(50));
		avatar.getInventory().findAndEquip(new Weapon(30));
		
		GameMap map = new GameMap();
		
		game.setAvatar(avatar);
		game.setMap(map);
		game.save();
		game.load();
		
		Avatar newAvatar = game.getAvatar();
		GameMap newMap = game.getMap();
		Inventory avatarInventory = newAvatar.getInventory();
		System.out.println(newAvatar + "\n---------------");
		System.out.println(avatarInventory + "\n---------------");
		System.out.println(newMap + "\n---------------");
	}
}
