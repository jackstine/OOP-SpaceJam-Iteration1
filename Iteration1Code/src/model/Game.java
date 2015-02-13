package model;

public class Game {
	GameMap map = new GameMap();
	Avatar avatar = new Avatar();
	
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
