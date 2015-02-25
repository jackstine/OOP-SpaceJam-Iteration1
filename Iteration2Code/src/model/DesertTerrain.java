package model;

public class DesertTerrain extends Terrain {
	
	private boolean passable;
	
	public DesertTerrain(){
		passable=true;
		terrainID='D';
	}

	public boolean isPassable() {
		return passable;
	}
	
	public void accept(TerrainVisitor visitor){
		visitor.accept(this);
	}
}
