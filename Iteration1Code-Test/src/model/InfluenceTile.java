package model;

public class InfluenceTile extends Tile {

	protected Tile tile;
	protected int radius;
	
	public InfluenceTile(Tile tile, int radius) {
		super(tile);
		this.tile = tile;
		this.radius = radius;
	}
	
	public InfluenceTile(Tile tile) {
		super(tile);
		this.tile = tile;
		this.radius = 0;
	}
	
	public Tile getTile() { return tile; }
	public int getRadius() { return radius; }
	public void setTile(Tile tile) { this.tile = tile; }
	public void setRadius(int radius) { this.radius = radius; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Influence Tile at: \n");
		sb.append(tile.getLocation() + "\n");
		sb.append("With radius " + radius + "\n");
		
		return sb.toString();
	}

}
