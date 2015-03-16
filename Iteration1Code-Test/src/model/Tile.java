package model;

import model.Entity.Entity;
import model.Entity.NPC;
import model.items.Item;
import model.items.ObstacleItem;

public class Tile {	
	
	private Terrain terrain;
	private Location location;
	private Item item;
	private Entity npc;
	// private AreaEffect areaEffect;
	private Decal decal;
	private Trap trap;

	public Tile(Terrain terrain, int x,int y){ //will take more parameters(maybe)
		this.terrain=terrain;
		location= new Location(x,y);
	}  
	
	//might not need it
	public Tile(Terrain terrain, Decal decal, int x, int y){
		this.terrain=terrain;
		this.decal= decal;
		location= new Location(x,y);
			
	}
	
	public Tile (Tile tile) {
		this.terrain = tile.getTerrain();
		this.location = tile.getLocation();
		this.item = tile.getItem();
		this.npc = tile.getNPC();
		this.decal = tile.getDecal();
		this.trap = tile.getTrap();
	}
	
	/*
	public Tile getTile(){  //not sure if this is needed. Leaving it here for later
		return this;
	}
	*/ 
	
	public Location getLocation(){  // can be deleted later. Used for debugging.
		return location;
	}

	public boolean isPassable(){
		
		return terrain.isPassable() && !(item instanceof ObstacleItem) && npc == null;  
	}
	//will probably need to add a setTerrain for the purpose
	//of making the map 
 
	public void setNPC(Entity n) {
		this.npc = n;
	}
	
	public void setTerrain(Terrain ter){  
		terrain=ter;
	}

	public Entity getNPC() {
		return npc;
	}
	
	public Terrain getTerrain(){
		return terrain;
	}

	public void setItem(Item item){
		this.item = item;
	}
	
	public Item dropItem(){
		Item temp = this.item;
		this.item = null;
		return temp;
	}
	
	public Item getItem(){
		return this.item;
	}
	
	public Decal getDecal(){
		return decal;
	}
	
	public void setDecal(Decal decal){
			this.decal=decal;
	}
	
	public Trap getTrap(){
		return trap;
	}
	
	public void setTrap(Trap trap){
		this.trap=trap;
	}
	
	/*
	public AreaEffect getAreaEffect(){
		return areaEffect;
	}
	*/
	
	/*
	public String toString(){
		return "Printing the image at ("+this.location.getX()+","+this.location.getY()+")";
	}
	*/
	
	public String toString() {
		String result = "";
		result += "Tile:" + this.location.getX() + "," + this.location.getY();
		result += "\n" + this.terrain;
		result += "\n" + this.decal;
		result += "\n" + this.item;	
		return result;
	}
}