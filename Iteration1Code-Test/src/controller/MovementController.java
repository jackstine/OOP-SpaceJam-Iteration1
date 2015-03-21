package controller;

import view.MapView;
import model.GameMap;
import model.Location;
import model.Point;
import model.QuestHandler;
import model.World;
import model.entity.Avatar;

public abstract class MovementController {
	public static final Point NORTH = new Point(0,-1);
	public static final Point SOUTH = new Point(0,1);
	public static final Point SOUTHWEST = new Point(-1,1);
	public static final Point NORTHWEST = new Point(-1,-1);
	public static final Point WEST = new Point(-1,0);
	public static final Point NORTHEAST = new Point(1,-1);
	public static final Point SOUTHEAST = new Point(1,1);
	public static final Point EAST = new Point(1,0);
	
	
	
	protected World world;
	protected MapView mapView;
	
	public abstract void move(Point step, int direction);
}
