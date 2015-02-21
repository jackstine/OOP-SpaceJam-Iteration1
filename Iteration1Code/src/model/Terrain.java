package model;


public abstract class Terrain {
	
	protected char terrainID;
	
	public abstract boolean isPassable();
	
	public char getTerrainID() {
		return terrainID;
	}
	
	public String toString() {
		return "Terrain:" + this.terrainID;
	}
	
	public abstract void accept(TerrainVisitor visitor);
}
