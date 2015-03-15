package model;

import model.Entity.Entity;

public class TeleportationAreaEffect implements AreaEffect {

	@Override
	public void apply(Entity entity) {
		entity.setCurrMap("Cave");
	}

}
