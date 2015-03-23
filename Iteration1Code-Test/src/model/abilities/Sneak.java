package model.abilities;

import model.GameLog;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class Sneak implements Spellable {
	public Entity entity;
	
	public Sneak(Entity entity){
		this.entity = entity;
	}

	public void apply(Entity entityToAffect) {
		EntityEffectHandler.stealth(entityToAffect);
		GameLog.writeToLog("Stealth activated", "Shhhh.... Sneaking");

	}
	
	public int getDamage(){
		return this.entity.attack();
	}

	public boolean able() {
		return true;
	}

}
