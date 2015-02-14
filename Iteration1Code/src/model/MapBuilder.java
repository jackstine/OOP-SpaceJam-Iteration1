package model;

import java.io.Serializable;
import java.util.HashMap;


public class MapBuilder implements Serializable{
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
		for(int i=0;i<this.height;i++){
			for(int j=0;j<this.width;j++){
				this.map[i][j]=new Tile(new DesertTerrain(),i,j);
				if((i==1 && j!= 7) || (j>-1 && j<3)){
						this.map[i][j].setTerrain(new RadioactiveWasteTerrain());
					}
			}
		}
		///Placing some items on the map  to pick up </5>
		for (int i = 5;i <= 8;i++){
			for (int j=3; j<=8; j++){
				if (j%2==0){
					Weapon weapon = new Weapon(i+j);
					this.map[i][j].setItem(weapon);
				}
				else{
					Armor armor = new Armor(i+j);
					this.map[i][j].setItem(armor);
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
	
	public Tile[][] generateStructuredMap(){
		this.map = new Tile[this.height][this.width]; // Sets the map size
		this.items = new Item[this.height][this.width];
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				if(i == 0 || j == 0 || i == this.width-1 || j == this.height-1)	// Mountains around the perimeter
					this.map[i][j] = new Tile(new MountainTerrain(),i,j);
				else if ((i == this.width/2 || (i == ((this.width/2) + 1))) &&  (j == this.height/2 || j == ((this.height/2)+1)))	//Waste in the middle
					this.map[i][j] = new Tile(new RadioactiveWasteTerrain(),i,j);
				else{
					this.map[i][j] = new Tile(new DesertTerrain(),i,j);		//Desert everywhere else
				}
			}
		}
		this.map[5][5].setDecal(new GoldStarDecal());
		this.map[3][8].setDecal(new RedCrossDecal());
		this.map[3][5].setDecal(new SkullAndCrossbonesDecal(new DamageAreaEffect(.50)));
		this.map[2][8].setDecal(new SkullAndCrossbonesDecal(new DeathAreaEffect()));
		Armor armor = new Armor(3+20);
		this.map[3][20].setItem(armor);
		this.items[3][20] = armor;
		
		Weapon weapon = new Weapon(20+49);
		this.map[8][8].setItem(weapon);
		this.items[8][8] = weapon;
		
		GiantRock gr = new GiantRock();
		this.map[3][20].setItem(gr);
		this.items[3][20] = gr;
		
		
		return this.map;
	}

	public Item[][] getItems(){
		return this.items;
	}
	
}