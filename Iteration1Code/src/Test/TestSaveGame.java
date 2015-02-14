package Test;

import model.*;

public class TestSaveGame {
	
	public static void main(String[] args) throws Exception {
		Game game = new Game();
		System.out.println("Avatar = " + game.getAvatar().getName());
		System.out.println(game.getAvatar().getInventory());
		Avatar avatar = new Avatar(new Terminator());
		avatar.setName("Arnold");
		avatar.getInventory().findAndEquip(new Armor(50));
		avatar.getInventory().findAndEquip(new Weapon(30));
		
		game.setAvatar(avatar);
		game.save();
		game.load();
		
		Avatar newAvatar = game.getAvatar();
		Inventory avatarInventory = newAvatar.getInventory();		
	}
}
