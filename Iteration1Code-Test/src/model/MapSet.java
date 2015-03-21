package model;

import java.util.HashMap;

import model.entity.Entity;

public class MapSet {
	private Tile[][] map;
	
	public MapSet(Tile[][] map) {
		this.map = new Tile[map.length][map[0].length];
		for(int c = 0; c < map[0].length; c++) {
			for(int r = 0; r < map.length; r++) {
				this.map[r][c] = map[r][c];
			}
		}
	}
	
	public Tile[][] getMap() {
		return map;
	}
	
	public int getHeight() {
		return map.length;
	}
	
	public int getWidth() {
		return map[0].length;
	}
	
	public Tile getTile(int r, int c) {
		return map[r][c];
	}
	
	public void setTile(int r, int c, Tile tile) {
		map[r][c] = tile;
	}
	
	public HashMap<Entity,Location> grabEntityLocations() {
		HashMap<Entity, Location> entityLocations = new HashMap<Entity,Location>();
		for(int r = 0; r < getHeight(); r++) {
			for(int c = 0; c < getWidth(); c++) {
				if(getTile(r,c).getEntity() != null) {
					//System.out.println("ADDING "+getTile(r,c).getEntity());
					entityLocations.put(getTile(r,c).getEntity(), new Location(r,c));
					System.out.println(getTile(r,c).getEntity().getClass().getName() + "@" + Integer.toHexString(getTile(r,c).getEntity().hashCode()));
				}
			}
		}
		return entityLocations;
	}
	
	public void setMap(Tile[][] map) {
		this.map = new Tile[map.length][map[0].length];
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				this.map[r][c] = map[r][c];
			}
		}
	}
}
