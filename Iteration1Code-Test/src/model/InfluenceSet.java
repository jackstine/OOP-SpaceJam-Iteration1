package model;

import java.util.Collection;

public abstract class InfluenceSet {
	protected Tile source;
	protected int radius;
	protected int direction;
	
	public abstract Collection<Tile> getInfluenceSet();
	public abstract void setSource(Tile source);
	public abstract void setRadius(int radius);
	public abstract void setDirection(int direction);
	
}
