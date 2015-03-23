package model;

import utilities.SoundEffect;
import utilities.VeryBadIdeaSoundEffect;
import model.entity.Entity;

public class BossAlertAreaEffect implements AreaEffect{
	private SoundEffect bossAlert;
	@Override
	public void apply(Entity entity) {
		bossAlert = new VeryBadIdeaSoundEffect();
	}

}
