package controller;

import model.Entity.*;
import model.GameMap;
import model.Location;
import model.Point;
import model.Tile;

public class WalkInCirlcesAIController extends AIController {

	public WalkInCirlcesAIController(NPC npc, GameMap map) {
		super(npc, map);
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
		
		@Override
		public void run() {
			while (true) {
				
				tile = map.getEntityTile(entity);
				if (tile != null) {
					//HERE'S WHERE WE NEED TO PUT WALKING IN A CIRCLE
				}
				
				System.out.println("AI RUNNING AND IN A LOOP");
				
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
