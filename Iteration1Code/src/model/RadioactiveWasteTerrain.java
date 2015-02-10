package model;

public class RadioactiveWasteTerrain extends Terrain{
	private boolean passable;

	public RadioactiveWasteTerrain(){
		passable=false;
	}

	public boolean isPassable(){
		return passable;
	}

}
