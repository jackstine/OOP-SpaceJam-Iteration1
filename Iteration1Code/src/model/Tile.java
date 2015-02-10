package model;

public class Tile{
	private Terrain terrain;
	private Location location;
	//private Item item;
	//private Entity entity;
	//private AreaEffect areaEffect;
	//private Decal decal;

	public Tile(Terrain terrain, int x,int y){ //will take more parameters
		this.terrain=terrain;
		location= new Location(x,y);

	}
	/*
	public Tile getTile(){  //not sure if this is needed. Leaving it here for later
		return this;
	}
	*/ 

	public boolean isPassable(){
		return terrain.isPassable();
	}
	//will probably need to add a setTerrain for the purpose
	//of making the map 
 
	public void setTerrain(Terrain ter){  
		terrain=ter;
	}

	public Terrain getTerrain(){
		return terrain;
	}

}