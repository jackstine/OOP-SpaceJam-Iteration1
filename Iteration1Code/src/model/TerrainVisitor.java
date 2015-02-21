package model;

public interface TerrainVisitor {
	public void accept(DesertTerrain t);
	public void accept(MountainTerrain t);
	public void accept(RadioactiveWasteTerrain t);
}
