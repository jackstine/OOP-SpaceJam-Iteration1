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

}
