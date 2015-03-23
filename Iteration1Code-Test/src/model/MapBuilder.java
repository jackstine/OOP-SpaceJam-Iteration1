package model;

import controller.NPCMovementController;
import model.entity.BossDavid;
import model.entity.Merchant;
import model.entity.Orc;
import model.entity.Skeleton;
import model.items.Armor;
import model.items.GiantRock;
import model.items.HealingOneShotItem;
import model.items.Item;
import model.items.TerminatorSingleWeapon;
import model.items.TreasureChest;
import model.items.Weapon;
import model.items.Weapons;

public class MapBuilder{
	protected Tile[][] map;
	protected int width;
	protected int height;
	protected Item[][] items;
	protected MapSet mapSet;

	public MapBuilder(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public MapBuilder(){
		this.width = 18;  //changed these from 35*35 to 18*18
		this.height = 18;
	}
	
	public MapSet generateMap(){
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
					Weapon weapon = new TerminatorSingleWeapon(i+j);
					this.map[i][j].setItem(weapon);
				}
				else{
					Armor armor = new Armor(i+j);
					this.map[i][j].setItem(armor);
				}
			}
		}
		return new MapSet(this.map);
	}
	
	public MapSet generateMapWithItems(){
		this.map= new Tile[this.height][this.width]; //just a test of the map
		this.items = new Item[this.height][this.width];
		for(int i=0;i<this.width;i++){
			for(int j=0;j<this.height;j++){
				this.map[j][i] = new Tile(new DesertTerrain(),i,j);
				if (j%2==0){
					Weapon weapon = new TerminatorSingleWeapon(i+j);
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
		return new MapSet(this.map);
	}
	//NEW MAP
	public MapSet generateStructuredMap(){
		this.map = new Tile[this.height][this.width]; // Sets the map size
		this.items = new Item[this.height][this.width];
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				if(i < 3 || j < 3 || i > this.width-4 || j > this.height-4)	// Mountains around the perimeter
					this.map[i][j] = new Tile(new MountainTerrain(),i,j);
				else if ((i == this.width/2 || (i == ((this.width/2) + 1))) &&  (j == this.height/2 || j == ((this.height/2)+1)))	//Waste in the middle
					this.map[i][j] = new Tile(new RadioactiveWasteTerrain(),i,j);
				else{
					this.map[i][j] = new Tile(new DesertTerrain(),i,j);		//Desert everywhere else
				}
			}
		}
		this.map[5][5].setDecal(new GoldStarDecal());
		this.map[4][8].setDecal(new RedCrossDecal());
		this.map[4][5].setDecal(new SkullAndCrossbonesDecal(new DamageAreaEffect(.50)));
		this.map[7][8].setDecal(new SkullAndCrossbonesDecal(new DeathAreaEffect()));
		this.map[7][7].setItem(new HealingOneShotItem(.50)); 
		this.map[4][10].setItem(new TreasureChest());
		this.map[6][12].setDecal(new TeleportationDecal("Cave"));
		Armor armor = new Armor(3+10);
		this.map[3][10].setItem(armor);
		this.items[3][10] = armor;
		
		Weapon weapon = Weapons.DAVESWORD.weapon;
		this.map[8][8].setItem(weapon);
		this.items[8][8] = weapon;
		
		GiantRock gr = new GiantRock();
		this.map[3][8].setItem(gr);
		this.items[3][8] = gr;
		
		this.map[3][12].setTrap(new SpikeTrap()); //this
		
		this.map[4][12].setEntity(new Merchant());
		this.map[9][12].setEntity(new Skeleton());
		this.map[14][12].setEntity(new Orc());
		//this.map[14][11].setEntity(new BossDavid());
		//NPCMovementController movePhil = new NPCMovementController(phil);
		//movePhil.doArtificialIntelligence();
		return new MapSet(this.map);
		
	}
	

	public MapSet generateStructuredMapv3(){
		int[] wasteTilesX = new int[] {4, 4, 4, 3, 4, 6, 6, 7, 7, 7, 7, 8, 9, 10, 9, 9, 9, 11,
				12, 12, 12, 12, 14, 9, 10, 5, 5, 4, 4, 7, 7, 7, 4, 5, 6};
		int[] wasteTilesY = new int[] {3, 4, 5, 7, 7, 5, 4, 4, 5, 6, 7, 7, 7, 7, 3, 5, 4, 7,
				7, 6, 5, 4, 6, 8, 8, 7, 8, 9, 10, 8, 9, 10, 11, 12, 11};

		this.map = new Tile[this.height][this.width]; // Sets the map size
		this.items = new Item[this.height][this.width];
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				if(i < 3 || j < 3 || i > this.width-4 || j > this.height-4)	// Mountains around the perimeter
					this.map[i][j] = new Tile(new MountainTerrain(),i,j);
				else if ((i == this.width/2 || (i == ((this.width/2) + 1))) &&  (j == this.height/2 || j == ((this.height/2)+1)))	//Waste in the middle
					this.map[i][j] = new Tile(new RadioactiveWasteTerrain(),i,j);
				else{
					this.map[i][j] = new Tile(new DesertTerrain(),i,j);		//Desert everywhere else
				}
			}
		}
		for (int i = 0; i < wasteTilesX.length; ++i ) {
			this.map[wasteTilesX[i]][wasteTilesY[i]].setTerrain(new RadioactiveWasteTerrain());
		}
		this.map[10][5].setDecal(new GoldStarDecal());
		this.map[8][8].setDecal(new RedCrossDecal());
		this.map[8][5].setDecal(new SkullAndCrossbonesDecal(new DamageAreaEffect(.50)));
		this.map[14][8].setDecal(new SkullAndCrossbonesDecal(new DeathAreaEffect()));
		this.map[14][7].setItem(new HealingOneShotItem(.50)); 
		this.map[8][10].setItem(new TreasureChest());
		Armor armor = new Armor(3+10);
		this.map[3][10].setItem(armor);
		this.items[3][10] = armor;
		this.map[4][5].setTerrain(new RadioactiveWasteTerrain());
		
		this.map[4][8].setDecal(new TeleportationDecal("Main"));
		GiantRock gr = new GiantRock();
		this.map[11][12].setItem(gr);
		//this.items[11][12] = gr;
		
		this.map[6][7].setTrap(new SpikeTrap());
		this.map[6][8].setTrap(new SpikeTrap());
		this.map[6][9].setTrap(new SpikeTrap());
		this.map[6][10].setTrap(new SpikeTrap());
		this.map[5][9].setTrap(new SpikeTrap());
		this.map[5][10].setTrap(new SpikeTrap());
		this.map[5][11].setTrap(new SpikeTrap());
		
		//NPC TEST
		
		Skeleton jacob = new Skeleton();
		Orc steve = new Orc();
		Orc dan = new Orc();
		Merchant ryan = new Merchant();
		
		//this.map[3][13].setEntity(ryan);
		//this.map[6][12].setEntity(jacob);
		this.map[12][12].setEntity(new BossDavid());
		//this.map[13][4].setEntity(dan);
		
		return new MapSet(this.map);
	}
	//renamed OLD map(this one) to V2
	public MapSet generateStructuredMapV2(){
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
		this.map[4][5].setTerrain(new RadioactiveWasteTerrain());
		Armor armor = new Armor(3+20);
		this.map[3][20].setItem(armor);
		this.items[3][20] = armor;
		
		Weapon weapon = Weapons.DAVESWORD.weapon;
		this.map[8][8].setItem(weapon);
		this.items[8][8] = weapon;
		
		GiantRock gr = new GiantRock();
		this.map[3][20].setItem(gr);
		this.items[3][20] = gr;
		
		
		return new MapSet(this.map);
	}

	public Item[][] getItems(){
		return this.items;
	}
	
}