package model;

import java.io.*;
import java.util.Map;

import model.Entity.Avatar;
import model.occupation.Alchemist;
import model.occupation.Occupation;
import model.occupation.Terminator;
import model.slots.Equipment;
import controller.SaveLoadController;

public class Game {
	World world;
	Avatar avatar;
	
	public Game() {
		world = new World();
		avatar = new Avatar(new Terminator());
	}
	
	public Game(World world, Avatar avatar) {
		this.world = world;
		this.avatar = avatar;
	}
	
	public Game(Occupation occupation, String name) {
		world = new World();
		//build the Avatar equipment
		
		avatar = new Avatar(occupation);
		avatar.setName(name);
		world.setAvatar(avatar);
	}
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
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
		//this.setMap(game.getMap());
	}
}
