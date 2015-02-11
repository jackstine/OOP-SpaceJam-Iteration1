package model;


public class MapBuilder{
	Tile[][] map;

	public MapBuilder(){
		map= new Tile[35][35]; //just a test of the map
		
		for(int i=0;i<35;i++){
			for(int j=0;j<35;j++){
				map[j][i]=new Tile(new DesertTerrain(),i,j);
				if((i==1 && j!= 7) || (j>-1 && j<3)){
					map[j][i].setTerrain(new RadioactiveWasteTerrain());
				}
			}
		}
	}

	public Tile[][] tileSet(){
		return map;
	}


}