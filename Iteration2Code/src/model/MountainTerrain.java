package model;


public class MountainTerrain extends Terrain {
	
	private boolean passable;

	public MountainTerrain(){
		passable=false;
		terrainID = 'M';
	}

	public boolean isPassable() {
		return passable;
	}
	
	public void accept(TerrainVisitor visitor){
		visitor.accept(this);
	}
}
