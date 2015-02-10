package model;

public class DesertTerrain extends Terrain{
	private boolean passable;

	public DesertTerrain(){
		passable=true;
	}

	public boolean isPassable() {
		return passable;
	}

}
