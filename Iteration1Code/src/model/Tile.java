package model;

public class Tile{
	private Terrain terrain;
	private Location location;
	private Item item;
	private Entity entity;
	private AreaEffect areaEffect;
	private Decal decal;

	public Tile(){

	}

	public Tile getTile(){
		return this;
	}

	public boolean isPassable(){
		//fill this in later
	}

}