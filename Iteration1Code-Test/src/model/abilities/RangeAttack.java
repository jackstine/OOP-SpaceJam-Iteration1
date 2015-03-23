package model.abilities;

import model.GameLog;
import model.entity.Entity;
import model.entity.EntityEffectHandler;

public class RangeAttack extends SpellSingleAffect{

	public RangeAttack(Entity entity) {
		super(entity);
	}
	
	public int getDamage(){
		return this.entity.attack();
	}

	public boolean able() {
		return true;
	}

	@Override
	protected void doTheSpell(Entity entityToAffect) {
		EntityEffectHandler.applyDamage(entityToAffect, this.getDamage());
		GameLog.writeToLog("Spell Damage", "You have dealt " + this.getDamage() + " damage.");
	}

	@Override
	public int getManaRequirement() {
		return 0;
	}

}
