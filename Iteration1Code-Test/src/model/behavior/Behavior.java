package model.behavior;

import model.entity.Entity;

public interface Behavior {
	
	public void perform(Entity initiate,Entity receiver);

	public void getBuffs();
}