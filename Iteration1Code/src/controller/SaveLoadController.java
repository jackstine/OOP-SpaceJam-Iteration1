package controller;

import java.util.*;
import java.io.*;
import model.*;

public class SaveLoadController {
	
	public static void save(Game game) throws IOException {
		// create the PrintWriter that will write to the file
		PrintWriter out = new PrintWriter(new File("savedGame.txt"));
		
		// write everything about the avatar
		Avatar avatar = game.getAvatar();
		out.println(avatar);
		out.println(avatar.getInventory());
		
		// write everything about the map
		GameMap map = game.getMap();
		out.close();
		System.out.println("GAME SAVED");
	}
	
	public static Game load() throws IOException {
		Scanner in = new Scanner(new File("savedGame.txt"));
		Game game = new Game();
		Avatar avatar = null;
		GameMap map = null;
		
		// load the Avatar information		
		String[] avatarName = in.next().split(":");
		String name = avatarName[1];
		
		String[] avatarOccupation = in.next().split(":");
		String occupation = avatarOccupation[1];
		
		// fix this later
		if (occupation.equals("Terminator")) avatar = new Avatar(new Terminator());
		if (occupation.equals("Alchemist")) avatar = new Avatar(new Alchemist());
		if (occupation.equals("Hunter")) avatar = new Avatar(new Hunter());
		
		for (int i = 0; i < 9; i++) {
			String[] primaryStat = in.next().split(":");
			String key = primaryStat[0];
			int value = Integer.parseInt(primaryStat[1]);
			avatar.setStatValue(key, value);
		}		
		
		String[] avatarDirection = in.next().split(":");
		int direction = Integer.parseInt(avatarDirection[1]);

		avatar.setName(name);
		avatar.setDirection(direction);
		
		Inventory inventory = new Inventory();
		String[] avatarInventory = in.next().split(":");
		int inventorySize = Integer.parseInt(avatarInventory[1]);
		
		for (int j = 0; j < inventorySize; j++) {
			String[] inventoryItem = in.next().split(":");
			String itemType = inventoryItem[0];
			int itemValue = Integer.parseInt(inventoryItem[1]);
			if (itemType.equals("Armor")) inventory.findAndEquip(new Armor(itemValue));
			if (itemType.equals("Weapon")) inventory.findAndEquip(new Weapon(itemValue));
		}
		
		avatar.setInventory(inventory);
		game.setAvatar(avatar);
		
		// load the GameMap information
		
		
		game.setMap(map);
		System.out.println("GAME LOADED");
		return game;
	}
}
