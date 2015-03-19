package model.behavior;

import model.entity.Entity;

public interface Behavior {
	
	public void perform(Entity entity);

	public void getBuffs();
}
