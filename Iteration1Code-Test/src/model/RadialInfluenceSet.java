package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

public class RadialInfluenceSet extends InfluenceSet {

	private int[] dx = new int[] {0, 1, 0, -1, 1, 1, -1, -1}; //  N, E, S, W, NE, SE, SW, NW
	private int[] dy = new int[] {1, 0, -1, 0, 1, -1, -1, 1}; //  0, 1, 2, 3,  4,  5,  6,  7
	
	private int sourceX;
	private int sourceY;
	
	private Collection<InfluenceTile> list = new ArrayList<InfluenceTile>();
	private Queue<QueueInfluenceTile> queue = new ArrayDeque<QueueInfluenceTile>();
	
	QueueInfluenceTile[][] influenceMap;
	
	public RadialInfluenceSet(GameMap map, Tile source, int radius, int direction) {
		setMap(map);
		setSource(source);
		setRadius(radius);
		setDirection(direction);
	}

	@Override
	public Collection<InfluenceTile> getInfluenceSet() {

		QueueInfluenceTile sourceTile = influenceMap[sourceX][sourceY];
		sourceTile.setRadius(0);

		computeAllTiles(sourceTile);
		
		return list;
	}
	
	@Override
	public void setMap(GameMap map) {
		super.setMap(map);
		
		Tile[][] tiles = map.tileSet();
		influenceMap = new QueueInfluenceTile[tiles.length][tiles[0].length];
		
		for (int i=0; i < tiles.length; ++i) {
			for (int j=0; j < tiles[0].length; j++) {
				influenceMap[i][j] = new QueueInfluenceTile(tiles[i][j]);
			}
		}
	}
	
	@Override
	public void setSource(Tile source) {
		super.setSource(source);
		this.sourceX = source.getLocation().getX();
		this.sourceY = source.getLocation().getY();
		
	}

		public void visitAllDirections(QueueInfluenceTile tile) {
			list.add(tile);
			
			//COMMENCE BLACK MAGIC POWERED SATANIC SUMMONING RITUAL
			int baseX = tile.getLocation().getX();
			int baseY = tile.getLocation().getY();
			
			QueueInfluenceTile attempt;
			
			for (int i=0; i < dx.length; ++i) {
				try {
					attempt = influenceMap[baseX + dx[i]][baseY + dy[i]];
					System.out.println(attempt);
					if (!attempt.visited() && (attempt.getRadius() < getRadius())) {
						System.out.println("Adding element to return set!");
						list.add(attempt);
						queue.offer(attempt);
						attempt.setRadius(tile.getRadius() + 1);
						attempt.setVisited(true);
					}
				}
				catch (Exception e) {
					//fail silently becuase I don't care how it fails.
					//Maybe index out of bounds, null pointer, etc...
					//Bottom line, it won't be added to the queue.
				}
			}
		}

		public void visitCardinalDirections(QueueInfluenceTile tile) {
			list.add(tile);
			
			int baseX = tile.getLocation().getX();
			int baseY = tile.getLocation().getY();
			QueueInfluenceTile attempt;
			
			for (int i=0; i < 4; ++i) {
				try {
					attempt = influenceMap[baseX + dx[i]][baseY + dy[i]];
					if (!attempt.visited() && (attempt.getRadius() < getRadius())) {
						System.out.println("Adding element to return set!");
						list.add(attempt);
						queue.offer(attempt);
						attempt.setRadius(tile.getRadius() + 1);
						attempt.setVisited(true);
					}
				}
				catch (Exception e) {
					//fail silently becuase I don't care how it fails.
					//Maybe index out of bounds, null pointer, etc...
				}
			}
		}

		public void computeAllTiles(QueueInfluenceTile tile) {
			queue.offer(tile);
			
			while(!queue.isEmpty()) {
				//System.out.println("Queue not empty! " +queue.size());
				//System.out.println(queue.peek());
				if (queue.peek().getRadius() <= getRadius()) {
					//System.out.println("Adding a tile to queue!");
					if (queue.peek().getRadius() == 1) {	//not purely evil because I made the queue :)
						//System.out.println("Doing CARDINAL add.");
						visitCardinalDirections(queue.poll());
					}
					else {
						//System.out.println("Doing ALL add.");
						visitAllDirections(queue.poll());
					}
				}
				//System.out.println("Tile outside radius. Abort.");
				queue.poll();
			}
			System.out.println("WE'VE ESCAPED THE QUEUE");
		}		
		
}
