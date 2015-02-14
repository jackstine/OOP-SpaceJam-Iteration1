package model;

import java.io.Serializable;

public class Game implements Serializable {
	GameMap map = new GameMap();
	Avatar avatar = new Avatar(new Alchemist());
	
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
}
