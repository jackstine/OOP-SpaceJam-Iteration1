package model;

import java.io.*;

import model.entity.Avatar;
import model.occupation.AvatarTerminator;
import model.occupation.Occupation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.entity.Avatar;
import model.entity.Entity;
import model.occupation.Alchemist;
import model.occupation.AvatarTerminator;
import model.occupation.Occupation;
import model.occupation.Terminator;
import model.slots.Equipment;
import controller.NPCMovementController;
import controller.SaveLoadController;

public class Game {
	World world;
	Avatar avatar;

	public Game() {
		avatar = new Avatar(new AvatarTerminator());
		world = new World(avatar);
		Map<String, GameMap> maps = world.getMaps();
		Set<String> mapNames = maps.keySet();
	}
	
	public Game(World world, Avatar avatar) {
		this.avatar = avatar;
		this.world = world;
		this.world.setWorldAvatar(avatar);
	}
	
	public Game(Occupation occupation, String name) {
		avatar = new Avatar(occupation);
		world = new World(avatar);
		//build the Avatar equipment
		avatar.setName(name);
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
		this.setWorld(game.getWorld());
	}
}
