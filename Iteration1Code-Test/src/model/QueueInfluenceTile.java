package model;


public class QueueInfluenceTile extends InfluenceTile{

	private boolean visited;
	
	public QueueInfluenceTile(Tile tile, int radius) {
		super(tile, radius);
		visited = false;
	}
	
	public QueueInfluenceTile(Tile tile) {
		super(tile);
		visited = false;
	}
	public boolean visited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(tile.getLocation() + "\n");
		sb.append("With radius " + radius + "\n");
		//debugPrintToFile(sb.toString());
		return sb.toString();
	}

}
