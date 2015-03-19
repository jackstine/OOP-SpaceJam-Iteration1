package model;

import model.entity.Entity;

public class TeleportationAreaEffect implements AreaEffect {
	private String nextMap;
	public TeleportationAreaEffect(String nextMap){
		this.nextMap=nextMap;
	}
	@Override
	public void apply(Entity entity) {
		entity.setCurrMap(nextMap);
	}

}
