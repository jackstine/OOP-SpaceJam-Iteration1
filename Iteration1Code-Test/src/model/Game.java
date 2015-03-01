package model;

import java.io.*;
import java.util.Map;

import model.occupation.Alchemist;
import model.occupation.Occupation;
import model.occupation.Terminator;
import model.slots.Equipment;
import controller.SaveLoadController;

public class Game {
	GameMap map;
	Avatar avatar;
	
	public Game() {
		map = new GameMap();
		avatar = new Avatar(new Terminator());
	}
	
	public Game(GameMap map, Avatar avatar) {
		this.map = map;
		this.avatar = avatar;
	}
	
	public Game(Occupation occupation, String name) {
		map = new GameMap();
		//build the Avatar equipment
		
		avatar = new Avatar(occupation);
		avatar.setName(name);
		map.setAvatar(avatar);
	}
	
	public GameMap getMap() {
		return map;
	}
	public void setMap(GameMap map) {
		this.map = map;
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	public void save() throws IOException {
		SaveLoadController.save(this);
	}
	
	public void load() throws IOException {
		Game game = SaveLoadController.load();
		this.setAvatar(game.getAvatar());
		this.setMap(game.getMap());
	}
}
