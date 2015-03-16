package model;

import java.util.ArrayList;
import java.util.Collection;

public class RadialInfluenceSet extends InfluenceSet {

	public RadialInfluenceSet(GameMap map, Tile source, int radius, int direction) {
		setMap(map);
		setSource(source);
		setRadius(radius);
		setDirection(direction);
	}

	@Override
	public Collection<InfluenceTile> getInfluenceSet() {
		ArrayList<InfluenceTile> list = new ArrayList<InfluenceTile>();
		list.add(new InfluenceTile(source, 0));
		
		return list;
	}
	
	

}
