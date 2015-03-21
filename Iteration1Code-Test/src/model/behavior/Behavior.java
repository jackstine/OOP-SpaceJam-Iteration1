package model.behavior;

import model.entity.Entity;

public interface Behavior {
	
	public void perform(Entity receiver);

	public void getBuffs();
	
	public void kill();
}
