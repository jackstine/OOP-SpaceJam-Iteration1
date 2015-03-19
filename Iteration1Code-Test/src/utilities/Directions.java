package utilities;

import controller.MovementController;
import model.Point;

public class Directions {
	
	public final static int SOUTHWEST = 1;
	public final static int SOUTH = 2;
	public final static int SOUTHEAST = 3;
	public final static int EAST = 6;
	public final static int NORTHEAST = 9;
	public final static int NORTH = 8;
	public final static int NORTHWEST = 7;
	public final static int WEST = 4;
	public final static int DANCE = 0;
	public final static int CENTRAL = 5;

	public final static int getOppositeDirection(int direction) {
		if (direction == SOUTHWEST) return NORTHEAST;
		if (direction == SOUTH) return NORTH;
		if (direction == SOUTHEAST) return NORTHWEST;
		if (direction == EAST) return WEST;
		if (direction == NORTHEAST) return SOUTHWEST;
		if (direction == NORTH) return SOUTH;
		if (direction == NORTHWEST) return SOUTHEAST;
		if (direction == WEST) return EAST;
		return -1;
	}
	
	public final static Point getPoint(int direction){
		if (direction == SOUTHWEST) return MovementController.SOUTHWEST;
		if (direction == SOUTH) return MovementController.SOUTH;
		if (direction == SOUTHEAST) return MovementController.SOUTHEAST;
		if (direction == EAST) return MovementController.EAST;
		if (direction == NORTHEAST)return MovementController.NORTHEAST;
		if (direction == NORTH) return MovementController.NORTH;
		if (direction == NORTHWEST) return MovementController.NORTHWEST;
		if (direction == WEST) return MovementController.WEST;
		return null;
	}
	
}
