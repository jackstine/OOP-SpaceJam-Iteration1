package testing;

import java.util.ArrayList;
import java.util.Collection;

import model.GameMap;
import model.InfluenceSet;
import model.InfluenceTile;
import model.LinearInfluenceSet;
import model.Point;
import model.Tile;

public class InfluenceSetTest {
	public static void main(String[] args){
	GameMap map = new GameMap();
	Tile t=map.getTile(new Point(13,13));
	InfluenceSet set = new LinearInfluenceSet(map,t,20,4);
	Collection<InfluenceTile> list = set.getInfluenceSet();
	for( InfluenceTile it : list){
		System.out.println(it.toString());
	}
	
	
	}

}
