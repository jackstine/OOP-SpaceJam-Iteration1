package testing;

import java.util.ArrayList;
import java.util.Collection;

import model.AngularInfluenceSet;
import model.GameMap;
import model.InfluenceSet;
import model.InfluenceTile;
import model.LinearInfluenceSet;
import model.Point;
import model.Tile;

public class InfluenceSetTest {
	public static void main(String[] args){
	GameMap map = new GameMap();
	Tile t=map.getTile(new Point(12,12));
	InfluenceSet set = new AngularInfluenceSet(map,t,3,7);
	Collection<InfluenceTile> list = set.getInfluenceSet();
	for( InfluenceTile it : list){
		System.out.println(it.toString());
	}
	
	
	}

}
