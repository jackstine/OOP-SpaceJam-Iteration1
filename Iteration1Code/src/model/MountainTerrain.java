package model;

public class MountainTerrain extends Terrain{
	private boolean passable;

	public MountainTerrain(){
		passable=false;
	}

	public boolean isPassable() {
		return passable;
	}

}
