package model;

import utilities.SoundEffect;
import model.entity.Entity;

public class BossAlertAreaEffect implements AreaEffect{
	private SoundEffect bossAlert;
	@Override
	public void apply(Entity entity) {
		bossAlert = new BossAlertSoundEffect();
	}

}
