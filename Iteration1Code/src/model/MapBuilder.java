package model;

import java.util.HashMap;


public class MapBuilder{
	protected Tile[][] map;
	protected int width;
	protected int height;
	protected Item[][] items;

	public MapBuilder(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public MapBuilder(){
		this.width = 35;
		this.height = 35;
	}
	
	public Tile[][] generateMap(){
		this.map= new Tile[this.height][this.width]; //just a test of the map
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.height;j++){
				this.map[i][j]=new Tile(new DesertTerrain(),j,i);
				if((i==1 && j!= 7) || (j>-1 && j<3)){
						this.map[i][j].setTerrain(new RadioactiveWasteTerrain());
					}
			}
		}
		return this.map;
	}
	
	public Tile[][] generateMapWithItems(){
		this.map= new Tile[this.height][this.width]; //just a test of the map
		this.items = new Item[this.height][this.width];
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.height;j++){
				this.map[j][i] = new Tile(new DesertTerrain(),i,j);
				if (j%2==0){
					Weapon weapon = new Weapon(i+j);
					this.map[j][i].setItem(weapon);
					this.items[j][i] = weapon;
				}
				else{
					Armor armor = new Armor(i+j);
					this.map[j][i].setItem(armor);
					this.items[j][i] = armor;
				}
			}
		}
		return this.map;
	}
	
	public Item[][] getItems(){
		return this.items;
	}
}