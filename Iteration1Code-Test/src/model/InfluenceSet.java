package model;

import java.util.Collection;

public abstract class InfluenceSet {
	private Tile source;
	private int radius;
	private int direction;
	
	public abstract Collection<Tile> getInfluenceSet();
}
