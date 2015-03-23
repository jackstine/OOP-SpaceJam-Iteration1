package model;

import utilities.CaveOfDaveSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;

public class TeleportationAreaEffect implements AreaEffect {
	private String nextMap;
	public TeleportationAreaEffect(String nextMap){
		this.nextMap=nextMap;
	}
	@Override
	public void apply(Entity entity) {
		if(nextMap.equals("Cave")) {
			SoundEffect cod = new CaveOfDaveSoundEffect();
		}
		entity.setCurrMap(nextMap);
	}

}
