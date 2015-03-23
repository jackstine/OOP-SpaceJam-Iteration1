package model.behavior;

import model.entity.Entity;
import model.entity.NPC;

public class Stand extends IdleBehavior {
	private Entity entity;
	
	public Stand(Entity entity){
		this.entity = entity;
	}
	
	public void perform(Entity receiver) {
		//do nothing
	}

	@Override
	public void getBuffs() {
		// TODO Auto-generated method stub
		
	}
	public void kill() {
	}
}
