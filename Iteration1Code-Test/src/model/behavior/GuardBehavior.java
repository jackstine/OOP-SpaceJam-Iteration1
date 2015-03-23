package model.behavior;

import model.GameMap;
import model.RadialInfluenceSet;
import model.entity.Entity;

public class GuardBehavior extends BehaviorComposite {
	
	private SightTrack sight;
	private Patrol patrol;
	private Pursue pursue;
	private Entity entity;
	
	boolean stopThread = false;
	
	public GuardBehavior(Entity entity, int radius) {
		this.entity = entity;
		sight = new SightTrack(entity);
		patrol = new Patrol(entity, radius);
		pursue = new Pursue(entity);
	}
	
	public void perform (Entity receiver) {
		GuardTask guard = new GuardTask();
		guard.start();
		stopThread = false;
		//pursue.perform(receiver);
	}
	
	public void trigger() {
		patrol.kill();
		pursue.perform(entity);
	}
	
	private class GuardTask extends Thread {
		
		@Override
		public void run() {
			try {
					sight.perform(entity);
					patrol.perform(entity);
					while(true) {
						System.out.print(".");
						if(sight.hasFoundTarget()) {
							trigger();
							break;
						}
					}
			} 
			catch (Exception e) {
			}
		}
	}
	
	public void kill() {
		patrol.kill();
		pursue.kill();
		sight.kill();
	}
}
