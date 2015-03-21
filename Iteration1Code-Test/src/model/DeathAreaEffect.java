package model;

import utilities.FriendlyDeathSoundEffect;
import utilities.SoundEffect;
import model.entity.Entity;



public class DeathAreaEffect implements AreaEffect{
	
	public void apply(Entity entity){
		EffectApplication.apply(entity, this);
		SoundEffect e = new FriendlyDeathSoundEffect();
	}
	
	public String toString() {
		return "DeathAreaEffect";
	}
}
