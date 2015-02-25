package model;

public class RadioactiveWasteTerrain extends Terrain {

	private boolean passable;

	public RadioactiveWasteTerrain(){
		passable=false;
		terrainID='R';
	}

	public boolean isPassable(){
		return passable;
	}
	
	public void accept(TerrainVisitor visitor){
		visitor.accept(this);
	}
}
