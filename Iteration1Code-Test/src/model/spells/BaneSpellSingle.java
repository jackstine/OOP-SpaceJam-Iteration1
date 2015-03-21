package model.spells;

import model.entity.Entity;
import model.entity.EntityEffectHandler;

public abstract class BaneSpellSingle extends SpellSingleAffect implements BaneSpell{

	public BaneSpellSingle(Entity entity) {
		super(entity);
	}
	
	protected final void doTheSpell(Entity entityToAffect) {
		EntityEffectHandler.applyDamage(entityToAffect, this.getDamage());
	}
}
