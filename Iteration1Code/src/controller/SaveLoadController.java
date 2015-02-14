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
		
		game.setAvatar(avatar);
		
		// load the GameMap information
		
		
		game.setMap(map);
		System.out.println("GAME LOADED");
		return game;
	}
}
