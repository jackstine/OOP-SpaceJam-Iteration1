package model.abilities;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public abstract class BaneAreaOfAffect extends SpellAreaOfEffect implements BaneSpell{

	public BaneAreaOfAffect(Entity entity) {
		super(entity);
	}

	public void happensInAreaAffect(Entity entityToAffect) {
		int damage = this.getDamage();
		EntityEffectHandler.applyDamage(entityToAffect, damage);
	}
}
