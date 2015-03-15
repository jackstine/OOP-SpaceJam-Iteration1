package controller;


import utilities.Directions;
import model.Entity.Entity;
import model.GameMap;
import model.Location;
import model.GameMap;
import model.Location;
import model.Entity.Entity;
import model.Entity.NPC;
import model.Point;
import model.Tile;

public class WalkInCirlcesAIController extends AIController {
	
	

	public WalkInCirlcesAIController(NPC npc, GameMap map) {
		super(npc, map);
		System.out.println("he");
		doArtificialIntelligence();
		
	}

	public void doArtificialIntelligence() {
		Thread task = new CircleTask();
		doTask(task);
		
	}
	
	private class CircleTask extends Thread {
		Entity entity = getNPC();
		GameMap map = getMap();
		Tile tile;
		
		private final Point NORTH = new Point(0,-1);
		private final Point SOUTH = new Point(0,1);
		private final Point SOUTHWEST = new Point(-1,1);
		private final Point NORTHWEST = new Point(-1,-1);
		private final Point WEST = new Point(-1,0);
		private final Point NORTHEAST = new Point(1,-1);
		private final Point SOUTHEAST = new Point(1,1);
		private final Point EAST = new Point(1,0);
		
		
		
		@Override
		public void run() {
			Point[] moves = {EAST, SOUTH, SOUTH, WEST, WEST, NORTH, NORTH, EAST};
			int[] directions 
				= {Directions.EAST, Directions.SOUTH, Directions.SOUTH, Directions.WEST, Directions.WEST, Directions.NORTH, Directions.NORTH, Directions.EAST};
			int count = 0;
			while (true) {
				
				tile = map.getEntityTile(entity);
				if (tile != null) {
					//HERE'S WHERE WE NEED TO PUT WALKING IN A CIRCLE
					entity.setDirection(directions[count]);
					if(map.getTile(temp.addLocation(moves[count])).isPassable()){
						npcLocation.add(moves[0]);		
					}
					else{
//						temp.add(point);
						System.out.println(temp + "   this is the temp location");
						System.out.println(npcLocation + "   this is the avtar");
						//System.out.println(map.getTile(temp).getNPC());
					}
					System.out.println(map.getTile(npcLocation).getTerrain());
				}
				
				System.out.println("AI RUNNING AND IN A LOOP");
				
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				++count;
			}
			
			
		}
	
		
//		public void move(Point point, int direction){
//			entity.setDirection(direction);
//			if(map.getTile(temp.addLocation(point)).isPassable()){
//				avatarLocation.add(point);
//				questHandler.apply(map.getTile(avatarLocation));
//				effectHandler.apply(map.getTile(avatarLocation));
//				
//			}
//			System.out.println(map.getTile(avatarLocation).getTerrain());	
//		}
	}

	
}
