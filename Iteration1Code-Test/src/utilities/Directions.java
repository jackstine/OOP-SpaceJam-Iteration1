package utilities;

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
	
}
