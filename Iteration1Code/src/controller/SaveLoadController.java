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
		System.out.println("We just saved a game!");
		System.out.println("----------------------");
	}
	
	public static Game load() throws IOException {
		Scanner in = new Scanner(new File("savedGame.txt"));
		Game game = new Game();
		Avatar avatar = null;
		GameMap map = null;
		
		String[] avatarName = in.next().split(":");
		String name = avatarName[1];
		
		String[] avatarOccupation = in.next().split(":");
		String occupation = avatarOccupation[1];
		
		if (occupation.equals("Terminator")) avatar = new Avatar(new Terminator());
		if (occupation.equals("Alchemist")) avatar = new Avatar(new Alchemist());
		if (occupation.equals("Hunter")) avatar = new Avatar(new Hunter());
		
		avatar.setName(name);
		
		game.setAvatar(avatar);
		game.setMap(map);
		return game;
	}
}
